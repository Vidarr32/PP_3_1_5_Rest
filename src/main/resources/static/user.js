function getUserInfo() {
    fetch('/api/user/userinfo')
        .then((response) => response.json())
        .then((user) => {
            let roles = user.roles
                            .map(role => " " + role.name.substring(5))
                            .reduce((result, value) => result + value);
            document.getElementById('head-username').innerHTML += user.email;
            document.getElementById('head-role').innerHTML += roles;
            document.getElementById('user-info').innerHTML += `
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.lastname}</td>
                    <td>${user.age}</td>
                    <td>${user.email}</td>
                    <td>${roles}</td>
                </tr>
            `;
        });
}

getUserInfo();