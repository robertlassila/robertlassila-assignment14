document.addEventListener("DOMContentLoaded", () => {
    const username = sessionStorage.getItem("username");
    if (username) {
        const hiddenInput = document.getElementById("messageUsername");
        if (hiddenInput) {
            hiddenInput.value = username;
        }
    } else {
        window.location.href = "/welcome";
    }

    const hiddenInput = document.getElementById("messageUsername");
    if (hiddenInput) hiddenInput.value = username;

    const channelId = document.body.dataset.channelId;
    if (!channelId) return;

    fetchMessages(channelId).then(currentMessages => {
        sessionStorage.setItem("previousMessages", JSON.stringify(currentMessages));
    });

    setInterval(async () => {
        const previousMessages = JSON.parse(sessionStorage.getItem("previousMessages")) || [];

        const newMessages = await fetchMessages(channelId);

        const prevIds = previousMessages.map(m => m.id).sort();
        const newIds = newMessages.map(m => m.id).sort();

        if (!arraysEqual(prevIds, newIds)) {
            window.location.reload();
        }
    }, 500);
});


async function fetchMessages(channelId) {
    try {
        const response = await fetch(`/api/messages/${channelId}`);
        if (response.ok) {
            return await response.json();
        } else {
            console.error("Failed to fetch messages");
            return [];
        }
    } catch (error) {
        console.error("Error fetching messages:", error);
        return [];
    }
}


function arraysEqual(a, b) {
    return a.length === b.length && a.every((val, index) => val === b[index]);
}
