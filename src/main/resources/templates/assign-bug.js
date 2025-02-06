document.getElementById('assign-bug-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const bugId = document.getElementById('bugId').value;
    const userId = document.getElementById('userId').value;

    fetch(`/bugs/${bugId}/assign/${userId}`, {
        method: 'POST'
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById('assign-message').innerText = 'Bug assigned successfully!';
        document.getElementById('assign-bug-form').reset();
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById('assign-message').innerText = 'Error assigning bug.';
    });
});
