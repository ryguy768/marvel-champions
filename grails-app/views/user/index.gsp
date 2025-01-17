<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>User Management</title>
</head>

<body>
<div id="content" role="main">
    <h1>User Management</h1>
    <table>
        <thead>
        <tr>
            <th>Username</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${users}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>
                    <button class="editButton" data-user-id="${user.id}">Edit</button>
                    <g:link controller="user" action="delete" id="${user.id}"
                            onclick="return confirm('Are you sure?')">Delete</g:link>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <g:link controller="user" action="create" class="button">Create New User</g:link>
</div>

</body>
</html>