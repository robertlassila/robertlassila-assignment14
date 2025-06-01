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

});



