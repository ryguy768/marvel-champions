document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('gameButton').addEventListener('click', function () {
        loadContent('/game/index', 'mainContent');
    });

    document.getElementById('userButton').addEventListener('click', function () {
        loadContent('/user/index', 'mainContent');
    });

    document.querySelectorAll('.editButton').forEach(function (button) {
        button.addEventListener('click', function (event) {
            event.preventDefault();
            const userId = button.getAttribute('data-user-id');
            loadContent(`/user/edit/${userId}`, 'editContent');
        });
    });
});

function loadContent(url, targetId) {
    fetch(url)
        .then(response => response.text())
        .then(data => {
            document.getElementById(targetId).innerHTML = data;
        })
        .catch(error => console.error('Error loading content:', error));
}