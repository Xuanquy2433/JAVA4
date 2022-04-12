/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


var catModal
catModal = new bootstrap.Modal(document.getElementById('addEmployeeModal'), {
    keyboard: false
})
document.getElementById("userForm").addEventListener('submit', (event) => {
    event.preventDefault();
    const txtUserName = document.querySelector('#txtUsername').value
    const txtPassword = document.querySelector('#txtPassword').value;
    const txtEmail = document.querySelector('#txtEmail').value
    const txtRole = document.querySelector('#txtRole').value
    const txtName = document.querySelector('#txtName').value

    const txtId = document.querySelector('#txtId').value || null;


    const errorUsername = document.querySelector('#error-username')
    const errorPass = document.querySelector('#error-password')
    const errorEmail = document.querySelector('#error-email');
    const errorRole = document.querySelector('#error-role');
    const errorName = document.querySelector('#error-name');


    console.log("iddddddddddddddddd " + txtId)
    if (txtId) {
//case update
        console.log("case update")
        const jsonObj = {
            id: Number(txtId),
            userName: txtUserName,
            password: txtPassword,
            email: txtEmail,
            role: txtRole,
            name: txtName,

        }
        console.log('jsonObj', jsonObj)
        fetch('/ASM-JAVA4/AdminUserController', {
            method: 'put',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(jsonObj)
        })
                .then(function (response) {
                    console.log('response', response)
                    return response.json();
                })
                .then(function (result) {
                    console.log(result)
                    const item = result.data
                    //success
//                            catModal.hide();
                    $('#addEmployeeModal').modal('hide')
                    //success
                    console.log('response', item)
                    $.toast({
                        heading: 'Success',
                        text: result.message,
                        position: 'bottom-right',
                        showHideTransition: 'slide',
                        icon: 'success'
                    })
                    resetForm();


                    console.log('theRowId', txtId)
                    var theRowId = $(`#catTable tbody tr[data-id='${Number(txtId)}']`);
                    console.log('remove', theRowId)
                    theRowId.remove();
                    $('#catTable tbody tr:first').after(`<tr data-id="${item.id}">
                                                <td>
                                                    <span class="custom-checkbox">
                                                        <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                                        <label for="checkbox1"></label>
                                                    </span>
                                                </td>
                                                <td>${item.userName}</td>
                                                <td>${item.password}</td>
                                                <td>${item.email}</td>
                                                <td>${item.role}</td>
                                                <td>${item.name}</td>

                                                <td>
                                                    <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" onclick="EditProduct(${item.id}, {
                                                                'userName': '${item.userName}',
                                                                'password': '${item.password}',
                                                                'email': '${item.email}',
                                                                'role': '${item.role}',
                                                                'name': ' ${item.name}'',

                                                            })" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                                    <a href="#deleteEmployeeModal567" class="delete" onclick="DeleteProduct(${item.id})" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                                </td>
                                            </tr>`);
                    resetForm();


                })
                .catch(function (error) {
                    //failed
                    console.log('Request failed', error);
                })

    } else {
//case post
        console.log("case post")

        if (txtUserName === '') {
            errorUsername.innerHTML = "Username required"
        } else if (txtPassword === '') {
            errorPass.innerHTML = "Password required field";
        } else if (txtEmail === '') {
            errorEmail.innerHTML = "Email required"
        } else if (txtRole === '') {
            errorRole.innerHTML = "Role required"
        } else if (txtName === '') {
            errorName.innerHTML = "Name required"
        } else {
            const jsonObj = {
                userName: txtUserName,
                password: txtPassword,
                email: txtEmail,
                role: txtRole,
                name: txtName,
            }

            fetch('/ASM-JAVA4/AdminUserController', {
                method: 'post',
                headers: {
                    'Accept': 'application/json, text/plain, */*',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(jsonObj)
            })
                    .then(function (response) {
                        console.log('response', response)
                        return response.json();
                    })
                    .then(function (result) {
                        //success
                        const item = result.data
                        //success
                        $("[data-dismiss=modal]").trigger({type: "click"}); //  close modal
                        console.log("thissssss")
                        $.toast({
                            heading: 'Success',
                            text: result.message,
                            position: 'bottom-right',
                            showHideTransition: 'slide',
                            icon: 'success'
                        })

                        console.log('them thanh cong')
                        console.log('theRowId', txtId)
                        var theRowId = $(`#catTable tbody tr[data-id='${Number(txtId)}']`);
                        console.log('remove', theRowId)
                        theRowId.remove();
                        $('#catTable tbody tr:first').after(`<tr>
                                                <td>
                                                    <span class="custom-checkbox">
                                                        <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                                        <label for="checkbox1"></label>
                                                    </span>
                                                </td>
                                                <td>${item.userName}</td>
                                                <td>${item.password}</td>
                                                <td>${item.email}</td>
                                                <td>${item.role}</td>
                                                <td>${item.name}</td>

                                                <td>
                                                    <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" onclick="EditProduct(${item.id}, {
                                                                'userName': '${item.userName}',
                                                                'password': '${item.password}',
                                                                'email': '${item.email}',
                                                                'role': '${item.role}',
                                                                'name': ' ${item.name}'',

                                                            })" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                                    <a href="#deleteEmployeeModal567" class="delete" onclick="DeleteProduct(${item.id})" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                                </td>
                                            </tr>`);
//                        console.log('ADD succsess')

                    })
                    .catch(function (error) {
                        //failed
                        console.log('Request failed', error);
                    })

//            event.currentTarget.submit()
        }
    }

}
)



function resetForm() {
    document.getElementById('userForm').reset();
}
function EditProduct(id, item) {
    console.log("click edit button " + item);
    var catModal
    catModal = new bootstrap.Modal(document.getElementById('addEmployeeModal'), {
        keyboard: false
    })
    catModal.show()
    console.log("click edit button");



    document.querySelector('#txtUsername').value = item.userName || ""
    document.querySelector('#txtPassword').value = item.password || ""
    document.querySelector('#txtEmail').value = item.email || ""
    document.querySelector('#txtRole').value = "user" || ""
    document.querySelector('#txtName').value = item.name || ""
    document.querySelector('#txtId').value = id || 0
    catModal.show()
}


function  ResetValue() {
    document.querySelector('#txtName').value = ""
    document.querySelector('#txtImage').value = ""
    document.querySelector('#txtPrice').value = ""
    document.querySelector('#txtDesc').value = ""
    document.querySelector('#error-name').value = ""
    document.querySelector('#error-desc').value = ""
    document.querySelector('#error-image').value = ""
    document.querySelector('#error-price').value = ""
}

function DeleteProduct(id) {
    console.log("Id delete ", id);
    if (!Number.isNaN(id)) {
        const obj = {
            "id": id
        }
        fetch('/ASM-JAVA4/AdminUserController', {
            method: 'delete',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(obj)
        })
                .then(function (response) {
                    console.log('response', response)
                    return response.json();
                })
                .then(function (result) {
                    $.toast({
                        heading: 'Success',
                        text: result.message,
                        position: 'bottom-right',
                        showHideTransition: 'slide',
                        icon: 'success'
                    })
                    setTimeout(() => {
                        location.reload();
                    }, 2000)

                })
                .catch(function (error) {
                    //failed
                    console.log('Request failed', error);
                })
    }
}
