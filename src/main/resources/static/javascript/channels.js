document.addEventListener("DOMContentLoaded", () => {
    const username = sessionStorage.getItem("username");
    console.log(username)
    if (username) {
        const hiddenInput = document.getElementById("messageUsername");
        if (hiddenInput) {
            hiddenInput.value = username;
        }
    } else {
        // Redirect to welcome if username isn't found
        window.location.href = "/welcome";
    }
});
