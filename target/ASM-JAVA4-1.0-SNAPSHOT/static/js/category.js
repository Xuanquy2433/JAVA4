var catModal
catModal = new bootstrap.Modal(document.getElementById('addEmployeeModal'), {
    keyboard: false
})
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
        fetch('/ASM-JAVA4/AdminCategoryController', {
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
                    $.toast({
                        heading: 'Success',
                        text: result.message,
                        position: 'bottom-right',
                        showHideTransition: 'slide',
                        icon: 'success'
                    })
                    console.log('udate thanh cong')

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
                                                <td class="col" >${item.image}</td>
                                                <!--<td>(171) 555-2222</td>-->
                                                <td>
                                                    <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" onclick="EditCategory(${item.id}, {
                                                                'name': '${item.name}',
                                                                'description': '${item.description}',
                                                                'image': '${item.image}'
                                                            })" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                                    <a href="#deleteEmployeeModalll" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
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
                                                <td class="col" >${item.image}</td>
                                                <!--<td>(171) 555-2222</td>-->
                                                <td>
                                                    <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" onclick="EditCategory(${item.id}, {
                                                                'name': '${item.name}',
                                                                'description': '${item.description}',
                                                                'image': '${item.image}'
                                                            })" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                                    <a href="#deleteEmployeeModallll" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                                </td>
                                            </tr>
`);
                        console.log('ADD succsess')

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
    console.log("click edit button");
    var catModal
    catModal = new bootstrap.Modal(document.getElementById('addEmployeeModal'), {
        keyboard: false
    })
    catModal.show()
    console.log("click edit button");
    console.log("id", id);
    console.log(item);
    document.querySelector('#txtName').value = item.name || ""
    document.querySelector('#txtImage').value = item.image || ""
    document.querySelector('#txtDesc').value = item.description || ""
    document.querySelector('#txtId').value = id || 0
    catModal.show()
}

function onDlt(id) {
    alert(id)
}

function DeleteCategory(id) {
    console.log("Id delete ", id);
    if (!Number.isNaN(id)) {
        const obj = {
            "id": id
        }
        fetch('/ASM-JAVA4/AdminCategoryController', {
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
