document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the default form submission

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    fetch('/admin/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password }), // Sending credentials as JSON
    })
    .then(response => {
        if (response.ok) {
            return response.text(); // Handle successful response
        } else {
            throw new Error('Invalid credentials');
        }
    })
    .then(data => {
        console.log(data); // For debugging, log success
        // Redirect to the admin panel or show success message
        window.location.href = "/admin/panel"; // Change this to your actual admin panel URL
    })
    .catch(error => {
        console.error(error);
        document.getElementById('errorMessage').innerText = error.message; // Display error message
    });
});
