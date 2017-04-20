

<%@page import="repository.ProductRepositoty"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="model.UserRole"%>
<%@page import="model.UserSessionHolder"%>
<%@page import="util.Settings"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ResourceBundle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Map<String, String> map = (HashMap<String, String>) Settings.getSessionAttribute(request, "languageCode");
    UserSessionHolder ush = Settings.getCurrentUserSession(request);

    List<Product> products = ProductRepositoty.getAllProduct();
    String cartSettings = "href=\"login.jsp\"";

    if (map == null) {
        request.getRequestDispatcher("language?lang=vi").forward(request, response);
    } else {
%>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="ContentType" content="text/html" charset="utf-8"/>
        <title><%=map.get("title")%></title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        <script src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/my-script.js"></script>
        <script src="js/base-ajax.js"></script>
    </head>
    <body> 
        <!--header-->
        <div class="header">
            <div class="top-header">
                <div class="container">
                    <div class="top-header-left">
                        <ul class="support">
                            <li><a href="error.jsp"><label> </label></a></li>
                            <li><a href="error.jsp"><%=map.get("live_support")%><span class="live"></span></a>
                               
                            </li>
                        </ul>
                        <ul class="support">
                            <li class="van"><a href="error.jsp"><label> </label></a></li>
                            <li><a href="error.jsp"><%=map.get("shipping")%><span class="live"></span></a></li>
                        </ul>
                    </div>
                    <div class="top-header-right">
                        <ul class="support">
                            <li><a href="language?lang=vi">Tiếng Việt</a><a href="#">|</a> 
                            <li><a href="language?lang=en">English</a>
                        </ul>        
                    </div>
                </div>
                <!---->
                <div class="clearfix"> </div>	
            </div>
            <div class="clearfix"> </div>		
        </div>
    </div>
    <div class="bottom-header">
        <div class="container">
            <div class="col-sm-3 header-bottom-left">
                <div class="logo">
                    <a href="index.jsp">E-<span>COMMERCE</span></a>
                </div>
                <div class="search">
                    <input type="text" value="" placeholder="<%=map.get("place_holder")%>" 
                           onfocus="this.value = '';" 
                           onblur="if (this.value === '') {
                                       this.value = '';
                                   }" >
                    <input type="submit"  value="<%=map.get("search")%>">

                </div>
                <div class="clearfix"> </div>
            </div>

            <div class="col-sm-6 header-bottom-right">	

                <% if (ush.getAccrole() == UserRole.GUEST) {%>
                <div class="account"><a href="login.jsp"><span></span><%=map.get("my_account")%></a></div>
                <ul class="login">
                    <li><a href="login.jsp"><span> </span><%=map.get("login")%> </a></li>
                    <li><a data-toggle="modal" data-target="#registerModal">| <%=map.get("reg")%></a></li>
                </ul>
                <% } else {
                    String settings = "";
                    if (ush.getAccrole().equals(UserRole.ADMINISTRATOR)) {
                        settings = "admin.jsp";
                        cartSettings = "data-toggle=\"modal\" data-target=\"#myModal\"";
                    } else if (ush.getAccrole().equals(UserRole.CUSTOMER)) {
                        settings = "account.jsp";
                        cartSettings = "data-toggle=\"modal\" data-target=\"#myModal\"";
                    } else if (ush.getAccrole().equals(UserRole.STAFF)) {
                        settings = "staff.jsp";
                        cartSettings = "data-toggle=\"modal\" data-target=\"#myModal\"";
                    }

                %>
                <div class="account"><a href="#"><span></span><%=map.get("account.welcome")%><%=ush.getAccname()%></a></div>
                <ul class="login">
                    <li><a href="<%=settings%>"><span> </span><%=map.get("account.setting")%> </a></li> 
                    <li><a href="logout">| <%=map.get("logout")%> </a></li>
                </ul>
                <%}%>

                <div class="cart"><a <%=cartSettings%>><span> </span><%=map.get("cart")%></a></div>
                <div class="clearfix"> </div>
            </div>

            <div class="clearfix"> </div>	
        </div>
    </div>
</div>

<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"><%=map.get("cart.title")%>
                    <input type="button" 
                           class="btn btn-primary btn-md"
                           value="<%=map.get("cart.refesh")%>" 
                           onclick="updateMyCart()"></h4>
            </div>
            <div class="modal-body">
                <div id="cart-content">
                    <table class="table table-hover">
                        <thead>
                            <tr class="danger">
                                <th><%=map.get("cart.id")%></th>
                                <th><%=map.get("cart.name")%></th>
                                <th><%=map.get("cart.price")%></th>
                            </tr>
                        </thead>

                        <tbody>

                            <%
                                List<Product> cartProduct = Settings.getCart(request).getProducts();
                                for (Product product : cartProduct) {
                                    out.print("<tr>"
                                            + "<td>" + product.getProductId() + "</td>"
                                            + "<td>" + map.get(product.getProductName()) + "</td>"
                                            + "<td>" + product.getProductPrice() + "</td></tr>");
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-md btn-primary" data-toggle="modal" data-target="#proceedModal"><%=map.get("cart.order")%></button>
                <button type="button" class="btn btn-md btn-default" data-dismiss="modal"><%=map.get("cart.close")%></button>
            </div>
        </div>

    </div>
</div>

<div class="modal fade" id="proceedModal" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h3 class="text-danger modal-title"><%=map.get("cart.anno")%></h3>
            </div>
            <div class="modal-body">
                <a href="order.jsp" class="btn btn-md btn-success "><%=map.get("cart.proceed")%></a>
                <button type="button" class="btn btn-md btn-danger pull-right" data-dismiss="modal"><%=map.get("cart.ignore")%></button>
            </div>
        </div>

    </div>
</div>    

<div class="modal fade" id="registerModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <img src="images/regpic.png" class="center-block" height="180">
                <h4 style="text-align: center;font-size: 25px">
                    <span style="color: #86b300" class="glyphicon glyphicon-cog"></span> <%=map.get("reg.title")%>
                </h4>
            </div>
            <div class="modal-body">
                <form role="form" action="signup" onsubmit="return(registerValidate())" method="post" name="regForm">
                    <div class="form-group">
                        <label for="usrname"><span style="color: #c7e600"class="glyphicon glyphicon-user"></span> <%=map.get("reg.usrnm")%></label>
                        <input type="text" name="regUsername" class="form-control" id="reg-username" placeholder="<%=map.get("reg.usrnmh")%>">
                        <div style="color:red" id="username-error"></div>
                    </div>
                    <div class="form-group">
                        <label for="usrname"><span class="glyphicon glyphicon-envelope"></span> Email</label>
                        <input type="text" name="regEmail" class="form-control" id="reg-email" placeholder="<%=map.get("reg.emailh")%>">
                        <div style="color:red" id="email-error"></div>
                    </div>
                    <div class="form-group">
                        <label for="usrname"><span style="color:#ff0066" class="glyphicon glyphicon-lock"></span> <%=map.get("reg.pass")%></label>
                        <input type="password" name="regPassword" class="form-control" id="reg-pass" placeholder="<%=map.get("reg.passh")%>">
                        <div style="color:red" id="pass-error"></div>
                    </div>
                    <div class="form-group">
                        <label for="psw"><span style="color:#e60000" class="glyphicon glyphicon-eye-open"></span> <%=map.get("reg.repass")%></label>
                        <input type="password" name="regRepass" class="form-control" id="reg-repass" placeholder="<%=map.get("reg.repassh")%>">
                        <div style="color:red" id="repass-error"></div>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block"><h5><%=map.get("reg.signup")%> <span class="glyphicon glyphicon-log-in"></span> </h5></button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> <%=map.get("cart.close")%></button>
                <p><%=map.get("reg.already")%> <a style="color: blue"href="login.jsp"><%=map.get("login")%></a></p>
                <p><a style="color: blue"href="#"> <%=map.get("login.help")%></a></p>
            </div>
        </div>
    </div>
</div>      

<script type="text/javascript">

    function registerValidate() {

        var username = document.getElementById("reg-username").value;
        var email = document.getElementById("reg-email").value;
        var password = document.getElementById("reg-pass").value;
        var repass = document.getElementById("reg-repass").value;

        if (username.length <= 0 || username.length > 16) {
            document.regForm.regUsername.focus();
            document.getElementById("username-error").innerHTML = '<%=map.get("reg.usrnmerr")%>';
            return false;
        }

        if (isEmailValidate(email) === false) {
            document.regForm.regEmail.focus();
            document.getElementById("email-error").innerHTML = '<%=map.get("reg.emailerr")%>';
            return false;
        }

        if (password.length <= 5 || password.length > 20) {
            document.regForm.regPassword.focus();
            document.getElementById("pass-error").innerHTML = '<%=map.get("reg.passerr")%>';
            return false;
        }

        if (password !== repass) {
            document.regForm.regPassword.focus();
            document.getElementById("pass-error").innerHTML = '<%=map.get("reg.repasserr")%>';
            document.getElementById("repass-error").innerHTML = '<%=map.get("reg.repasserr")%>';
            return false;
        }

        return true;
    }


</script>
<!---->
<div class="container">
    <h3><b>FAQs - Những câu hỏi thường gặp</b> </h3>
    <ol>
        <li><b>Mua hàng tại E-commerce có đảm bảo hay không ?</b> _ Hàng hoá, sản phẩm của E-commerce đều có nguồn gốc rõ ràng và được bảo hành đầy đủ theo quy định của nhà sản xuất.</li>
        <li><b>Liệu tôi có thể thanh toán bằng các hình thức nào ?</b> _ Bạn có thể thanh toán cho E-commerce khi bằng tiền mặt khi nhận hàng (COD) hoặc thanh toán chuyển khoản qua ngân hàng, hoặc thanh toán qua các hệ thống ví điện tử như Ngân Lượng, Bảo Kim...</li>
        <li><b>Tôi có thể theo dõi sản phẩm của tôi không?</b> _ Các đơn hàng của chúng tôi đều kèm theo mã tracking của các dịch vụ giao nhận được sử dụng, nên bạn có thể yên tâm theo dõi quá trình giao nhận.</li>
        <li><b>Tôi có một món hàng mua nhưng không vừa ý hoặc kích thước không đúng yêu cầu thì E-commerce có thể hỗ trợ gì cho tôi ?</b> _ E-commerce sẽ bảo hành cho bạn theo đúng chế độ của nhà cung cấp, và có chế độ 1 đổi 1 trong 7 ngày đầu cho các trường hợp như không vừa kích cỡ, không đúng màu, lỗi do nhà sản xuất.</li>
        <li><b>E-commerce có nhận giao hàng ở các khu vực nào ?</b> _ Hiện tại, E-commerce nhận giao các sản phẩm qua các dịch vụ giao nhận khắp cả nước và trong tương lai sẽ có dịch vụ gia hàng ra cho các khu vực lân cận ngoài nước.</li>
    </ol>
        
    <div class="clearfix"> </div>        	         
</div>
<div class="temp">

</div>
<div class="clearfix"> </div>
<div class="footer-top">
    <div class="container">
        <div class="foo-grids">
            <div class="col-md-3 footer-grid">
                <h4 class="footer-head"><%=map.get("intro")%></h4>
                <%=map.get("intro_deep")%>
            </div>
            <div class="col-md-3 footer-grid">
                <h4 class="footer-head"><%=map.get("help")%></h4>
                <ul>
                    <li><a href="error.jsp"><%=map.get("sitemap")%></a></li>						
                    <li><a href="error.jsp"><%=map.get("footer.control")%></a></li>
                    <li><a href="FAQ.jsp">FAQ</a></li>
                    <li><a href="feed.jsp"><%=map.get("feed")%></a></li>
                    <li><a href="contact.jsp"><%=map.get("contact")%></a></li>
                    <li><a href="error.jsp">Code</a></li>
                </ul>
            </div>
            <div class="col-md-3 footer-grid">
                <h4 class="footer-head"><%=map.get("info")%></h4>
                <ul>
                    <li><a href="error.jsp"><%=map.get("locale")%></a></li>	
                    <li><a href="error.jsp"><%=map.get("terms")%></a></li>
                    <li><a href="error.jsp"><%=map.get("pop_search")%></a></li>	
                    <li><a href="error.jsp"><%=map.get("secure")%></a></li>	
                </ul>
            </div>
            <div class="col-md-3 footer-grid">
                <h4 class="footer-head"><%=map.get("contacts")%></h4>
                <span class="hq"><%=map.get("headq")%></span>

                <ul class="location">
                    <li><span class="glyphicon glyphicon-map-marker"></span></li>
                    <li><a href="error.jsp"><%=map.get("hrm")%></a></li>
                    <div class="clearfix"></div>
                </ul>	
                <ul class="location">
                    <li><span class="glyphicon glyphicon-earphone"></span></li>
                    <li><a href="error.jsp">+0 561 111 235</a></li>
                    <div class="clearfix"></div>
                </ul>	
                <ul class="location">
                    <li><span class="glyphicon glyphicon-envelope"></span></li>
                    <li><a href="error.jsp">ecommerce@hcmiu.edu.vn.com</a></li>
                    <div class="clearfix"></div>
                </ul>						
            </div>
            <div class="clearfix"></div>
        </div>						
    </div>	
</div>	
</body>
</html>
<%}%>   
