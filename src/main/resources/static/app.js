function loadBugs() {
    fetch('/bugs')
        .then(response => response.json())
        .then(bugs => {
            const bugList = document.getElementById('bugs-list');
            bugList.innerHTML = '';  // Clear the previous list
            bugs.forEach(bug => {
                const bugElement = document.createElement('div');
                bugElement.classList.add('bug-item');
                bugElement.innerHTML = `
                    <h3>${bug.title}</h3>
                    <p>${bug.description}</p>
                    <p>Status: ${bug.status}</p>
                `;
                bugList.appendChild(bugElement);
            });
        })
        .catch(error => console.error('Error loading bugs:', error));
}
