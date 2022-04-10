/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


var catModal
catModal = new bootstrap.Modal(document.getElementById('addEmployeeModal'), {
    keyboard: false
})
document.getElementById("productForm").addEventListener('submit', (event) => {
    event.preventDefault();
    const txtName = document.querySelector('#txtName').value
    const txtImage = document.querySelector('#txtImage').value;
    const txtDescription = document.querySelector('#txtDesc').value
    const txtPrice = document.querySelector('#txtPrice').value
    const categoryId = document.querySelector('#category').value



    const txtId = document.querySelector('#txtId').value || null;
    const errorName = document.querySelector('#error-name')
    const errorDes = document.querySelector('#error-desc')
    const errorImage = document.querySelector('#error-image');
    const errorPrice = document.querySelector('#error-price');

    if (txtId) {
//case update
        console.log("case update")
        console.log("id" + categoryId);
        if (!/^[0-9]+$/.test(txtPrice)) {
            errorPrice.innerHTML = "Please only enter numeric characters only for your price! (Allowed input:0-9)";
        }
        const jsonObj = {
            id: Number(txtId),
            name: txtName,
            image: txtImage,
            price: txtPrice,
            description: txtDescription,
            categoryId: Number(categoryId)
        }
        console.log('jsonObj', jsonObj)
        fetch('/ASM-JAVA4/AdminProductController', {
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
                    setTimeout(() => {
                        location.reload();
                    }, 1000)

                    console.log("abcccc123")
                    console.log('udate thanh cong ')
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
                                                <td>${item.image}</td>
                                                <td>${item.price}</td>
                                                <td>${item.description}</td>
                                                 <td>${item.categoryId}</td>
                                               
                                                <td>
                                                    <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" onclick="EditProduct(${item.id}, {
                                                                'name': '${item.name}',
                                                                'image': '${item.image}',
                                                                'price': '${item.price}',
                                                                'description': '${item.description}'

                                                            })" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                                    <a href="#deleteEmployeeModalll" class="delete" onclick="DeleteProduct(${item.id})"  data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                                    
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
        console.log("id:" + categoryId)

        if (txtName === '') {
            errorName.innerHTML = "Name required"
        } else if (txtImage === '') {
            errorImage.innerHTML = "Image required field";
        } else if (txtPrice === '') {
            errorPrice.innerHTML = "Price required"
        } else if (!/^[0-9]+$/.test(txtPrice)) {
            errorPrice.innerHTML = "Please only enter numeric characters only for your price! (Allowed input:0-9)";
        } else if (txtDescription === '') {
            errorDes.innerHTML = "Description required"
        } else {
            const jsonObj = {
                name: txtName,
                image: txtImage,
                price: txtPrice,
                description: txtDescription,
                categoryId: Number(categoryId)
            }

            fetch('/ASM-JAVA4/AdminProductController', {
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
                        $('#catTable tbody tr:first').after(`
 <tr data-id="${item.id}">
                                                <td>
                                                    <span class="custom-checkbox">
                                                        <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                                        <label for="checkbox1"></label>
                                                    </span>
                                                </td>
                                                <td>${item.name}</td>
                                                <td>${item.image}</td>
                                                <td>${item.price}</td>
                                                <td>${item.description}</td>
                                                <td>${item.categoryId}</td>

                                                <!--<td>(171) 555-2222</td>-->
                                                <td>
                                                    <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" onclick="EditProduct(${item.id}, {
                                                                'name': '${item.name}',
                                                                'image': '${item.image}',
                                                                'price': '${item.price}',
                                                                'description': '${item.description}'

                                                            })" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                                    <a href="#deleteEmployeeModalll" class="delete" onclick="DeleteProduct(${item.id})"  data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                                    
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

function validateForm() {

    var z = document.forms["myForm"]["num"].value;

    if (!/^[0-9]+$/.test(z)) {
        alert("Please only enter numeric characters only for your Age! (Allowed input:0-9)")
    }

}

function resetForm() {
    document.getElementById('productForm').reset();
}
function EditProduct(id, item) {
    console.log("click edit button");
    var catModal
    catModal = new bootstrap.Modal(document.getElementById('addEmployeeModal'), {
        keyboard: false
    })
    catModal.show()
    console.log("click edit button123123");

    console.log("id ", item.categoryId);
    console.log(item);


    document.querySelector('#txtName').value = item.name || ""
    document.querySelector('#txtImage').value = item.image || ""
    document.querySelector('#txtPrice').value = item.price || ""
    document.querySelector('#txtDesc').value = item.description || ""
    document.querySelector('#txtId').value = id || 0
//    document.querySelector('#category').value = "category" || 0
    document.getElementById('category').value = 169
    catModal.show()
}

function onDlt(id) {
    alert(id)
}

function abc() {
    console.log("abc")
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
        fetch('/ASM-JAVA4/AdminProductController', {
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
