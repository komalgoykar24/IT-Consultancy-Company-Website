document.addEventListener("DOMContentLoaded", function() {
    fetchContacts();
    fetchInternshipApplications();
    fetchEmploymentApplications();
});

function fetchContacts() {
    fetch('/contacts')
        .then(response => response.json())
        .then(data => {
            const contactsDiv = document.getElementById('contacts');
            contactsDiv.innerHTML = data.map(user => `<p>${user.name} - ${user.email}</p>`).join('');
        })
        .catch(error => console.error('Error fetching contacts:', error));
}

function fetchInternshipApplications() {
    fetch('/internships')
        .then(response => response.json())
        .then(data => {
            const internshipsDiv = document.getElementById('internships');
            internshipsDiv.innerHTML = data.map(app => `<p>${app.candidateName} - ${app.status}</p>`).join('');
        })
        .catch(error => console.error('Error fetching internships:', error));
}

function fetchEmploymentApplications() {
    fetch('/employments')
        .then(response => response.json())
        .then(data => {
            const employeesDiv = document.getElementById('employees');
            employeesDiv.innerHTML = data.map(app => `<p>${app.candidateName} - ${app.status}</p>`).join('');
        })
        .catch(error => console.error('Error fetching employees:', error));
}
