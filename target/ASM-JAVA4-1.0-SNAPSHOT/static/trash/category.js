/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
//admincategorycontroller
//            request.setCharacterEncoding("UTF-8");
//            String name = request.getParameter("name").toString();
//            String image = request.getParameter("image");
//            String desc = request.getParameter("desc");
//
//            if (!name.equals("")) {
//                System.out.println("image" + image);
//                System.out.println("name:    " + name);
//                CategoryDTO dto = new CategoryDTO(name, desc, image);
//                CategoryDao dao = new CategoryDao();
//                boolean isCreate = dao.create(dto);
//
//                if (isCreate) {
//                    try ( PrintWriter out = response.getWriter()) {
//                        /* TODO output your page here. You may use following sample code. */
//                        out.println("<!DOCTYPE html>");
//                        out.println("<html>");
//                        out.println("<head>");
//                        out.println("<title>Servlet HomeServlet</title>");
//
//                        out.println("</head>");
//                        out.println("<body style='font-family: Arial, Helvetica, sans-serif;' >");
//
//                        out.println("<script type=\"text/javascript\">");
//                        out.println("alert('Add category sucsess');");
//                        out.println("location='/ASM-JAVA4/AdminCategoryController';");
//                        out.println("</script>");
//
//                        out.println("</div>");
//
//                        out.println("</body>");
//                        out.println("</html>");
//                    }
//                } else {
//                    try ( PrintWriter out = response.getWriter()) {
//                        /* TODO output your page here. You may use following sample code. */
//                        out.println("<!DOCTYPE html>");
//                        out.println("<html>");
//                        out.println("<head>");
//                        out.println("<title>Servlet HomeServlet</title>");
//
//                        out.println("</head>");
//                        out.println("<body style='font-family: Arial, Helvetica, sans-serif;' >");
//
//                        out.println("<script type=\"text/javascript\">");
//                        out.println("alert('Add category fails');");
//                        out.println("location='/ASM-JAVA4/AdminCategoryController';");
//                        out.println("</script>");
//
//                        out.println("</div>");
//
//                        out.println("</body>");
//                        out.println("</html>");
//                    }
//                }
//            }
   <script>


//            let formCategory = document.getElementById("categoryForm")
//
//                    formCategory.addEventListener('submit', (event) => {
//                    console.log('abc');
//                    event.preventDefault()
//
//                            const txtName = document.querySelector('#txtName').value;
//                    const txtImage = document.querySelector('#txtImage').value;
//                    const txtDesc = document.querySelector('#txtDesc').value;
//                    const txtId = document.querySelector('#txtId').value || null;
//                    const errorName = document.querySelector('#error-name');
//                    const errorImage = document.querySelector('#error-image');
//                    const errorDesc = document.querySelector('#error-desc');
//                    if (txtId){
//
//                    }
//                    else{
//
//                    if (txtName === '') {
//                    errorName.innerHTML = "Name required field";
//                    } else if (txtImage === '') {
//                    errorImage.innerHTML = "Image required field";
//                    } else if (txtDesc === '') {
//                    errorDesc.innerHTML = "Description required field";
//                    } else {
////                    event.currentTarget.submit();
//                    const jsonObj = {
//                    name: txtName,
//                            description: txtDesc,
//                            image: txtImage
//                    }
//                    fetch('/ASM-JAVA4/AdminCategoryController', {
//                    method: 'post',
//                            headers: {
//                            'Accept': 'application/json, text/plain, */*',
//                                    'Content-Type': 'application/json'
//                            },
//                            body: JSON.stringify(jsonObj)
//                    })
//                            .then(function (response) {
//                            console.log('response', response)
//                                    return response.json();
//                            })
//                            .then(function (result) {
//                            //success
//                            console.log('response', result)
//                                    catModal.hide();
////                          location.reload();
//                            })
//                            .catch(function (error) {
//                            //failed
//                            console.log('Request failed', error);
//                            })
//
//                    }
//
//
//
//                    })
//                    }
//
//                    function EditCategory(id) {
//                    alert(id)
//                    }


        </script>