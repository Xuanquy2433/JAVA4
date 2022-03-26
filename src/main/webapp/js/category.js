/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let formCategory = document.getElementById("categoryForm");
formCategory.addEvenListener("submit", (event) => {
    console.log('abc');
  const txtName = document.querySelector("#txtName").value;
  const errorName = document.querySelector("#error-name");

  if (txtName === "") {
    alert("loi");
  } else {
    event.currenTarget.submit();
  }
});
