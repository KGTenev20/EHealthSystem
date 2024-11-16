// src/main/resources/static/js/navbarLoader.js
document.addEventListener('DOMContentLoaded', function() {
    fetch('/templates/navbar.html')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();
        })
        .then(data => {
            document.body.innerHTML = data;
        })
        .catch(error => console.error('Error loading navbar:', error));
});
