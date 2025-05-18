document.getElementById("welcome-form").addEventListener("submit", function(event) {
    const usernameInput = document.getElementById("username")
    const username = usernameInput.value.trim()
    const errorMsg = document.getElementById("error-msg")

    if (username === "") {
        event.preventDefault()
        errorMsg.textContent = "Username cannot be empty."
        usernameInput.focus()
    } else {
        errorMsg.textContent = ""

        sessionStorage.setItem("username", username);

        // Redirect to /channels and prevent actual form submission
        event.preventDefault();
        window.location.href = "/channels";

    }
})