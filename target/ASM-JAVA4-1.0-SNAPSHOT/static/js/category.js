

document.getElementById("categoryForm").addEventListener('submit', (event) => {
    event.preventDefault();
    const txtName = document.querySelector('#txtName').value
    const txtImage = document.querySelector('#txtImage').value;
    const txtDescription = document.querySelector('#txtDesc').value

    const txtNameUp = document.querySelector('#txtName').value
    const txtImageUp = document.querySelector('#txtImage').value;
    const txtDescriptionUp = document.querySelector('#txtDesc').value
    const txtId = document.querySelector('#txtId').value || null;


    const errorName = document.querySelector('#error-name')
    const errorDes = document.querySelector('#error-desc')
    const errorImage = document.querySelector('#error-image');
    if (txtId) {
        //case update
        console.log("case update")
        const jsonObj = {
            id: Number(txtId),
            name: txtName,
            description: txtDescription,
            image: txtImage
        }
        console.log('jsonObj', jsonObj)
        fetch('/lessonJSP/admin/AdminCategoryController', {
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
                    const item = result.data
                    //success
//                            catModal.hide();
                    $('#addEmployeeModal').modal('hide')
                    //success
                    console.log('response', item)
                    console.log('okkkkkkkkkkkkk')
                    $.toast({
                        heading: 'Success',
                        text: result.message,
                        position: 'top-right',
                        showHideTransition: 'slide',
                        icon: 'success'
                    })
//                    location.reload();
                    resetForm();
                    console.log('theRowId', txtId)
                    var theRowId = $(`#catTable tbody tr[data-id='${Number(txtId)}']`);
                    console.log('remove', theRowId)
                    theRowId.remove();
                    $('#catTable tbody tr:first').after(`
                    <tr data-id="${item.id}">
                                                <td>
                                                    <span class="custom-checkbox">
                                                        <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                                        <label for="checkbox1"></label>
                                                    </span>
                                                </td>
                                                <td>${item.name}</td>
                                                <td>${item.description}</td>
                                                <td>${item.image}</td>
                                                <!--<td>(171) 555-2222</td>-->
                                                <td>
                                                    <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" onclick="EditCategory(${item.id}, {
                                                                'name': '${item.name}',
                                                                'description': ' ${item.description}',
                                                                'image': '${item.image}'
                                                            })" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                                    <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                                </td>
                                            </tr>
`);

                    resetForm()

                })
                .catch(function (error) {
                    //failed
                    console.log('Request failed', error);
                })

    } else {
        //case post
        console.log("case post")
        if (txtName === '') {
            errorName.innerHTML = "Name required"
        } else if (txtImage === '') {
            errorImage.innerHTML = "Image required field";
        } else if (txtDescription === '') {
            errorDes.innerHTML = "Description required"
        } else {
            const jsonObj = {
                name: txtName,
                description: txtDescription,
                image: txtImage
            }

            fetch('/ASM-JAVA4/AdminCategoryController', {
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
                        console.log('response', result)
                        location.reload();
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
    document.getElementById('categoryForm').reset();
}
function EditCategory(id, item) {
    var catModal
    catModal = new bootstrap.Modal(document.getElementById('addEmployeeModal'), {
        keyboard: false
    })
    catModal.show()
    console.log("id", id);
    console.log(item);
    document.querySelector('#txtName').value = item.name || ""
    document.querySelector('#txtImage').value = item.image || ""
    document.querySelector('#txtDesc').value = item.description || ""
    document.querySelector('#txtId').value = id || 0
    catModal.show()
}

