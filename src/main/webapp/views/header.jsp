<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark" style="position: fixed; top: 0; width:100%;  z-index: 100000;">
  <div class="container">
    <a class="navbar-brand" href="home">Bananas</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
      <ul class="navbar-nav m-auto">
        <li class="nav-item">
          <a class="nav-link" href="home"><i class="fas fa-home"></i> Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="shop"><i class="fas fa-shopping-bag"></i> Shop</a>
        </li>
        <c:if test="${sessionScope.acc != null}">
          <li class="nav-item">
            <a class="nav-link" href="#"><i class="fas fa-user"></i> Hello ${sessionScope.acc.firstName}</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
          </li>
        </c:if>
        <c:if test="${sessionScope.acc == null}">
          <li class="nav-item">
            <a class="nav-link" href="login"><i class="fas fa-sign-in-alt"></i> Login</a>
          </li>
        </c:if>
        <c:if test="${sessionScope.acc == null}">
          <li class="nav-item">
            <a class="nav-link" href="forgotPassword"><i class="fas fa-key"></i> Forgot Password</a>
          </li>
        </c:if>
        <c:if test="${sessionScope.acc != null}">
          <li class="nav-item">
            <a class="nav-link" href="editProfile"><i class="fas fa-edit"></i> Edit Profile</a>
          </li>
        </c:if>
        <c:if test="${sessionScope.acc != null}">
          <li class="nav-item">
            <a class="nav-link" href="history"><i class="fas fa-history"></i> Purchase History</a>
          </li>
        </c:if>
        <c:if test="${sessionScope.acc != null and sessionScope.acc.role eq 'admin'}">
          <li class="nav-item">
            <a class="nav-link" href="hoaDon"><i class="fas fa-cogs"></i> Admin</a>
          </li>
        </c:if>

      </ul>

      <form action="search" method="post" class="form-inline my-2 my-lg-0">

        <a class="btn btn-success btn-sm ml-3" href="view_cart">
          <i class="fa fa-shopping-cart"></i> <span style="font-size: 14px;">Cart</span>
          <b><span id="amountCart" class="badge badge-light" style="color:black; font-size: 12px;"></span></b>
        </a>

      </form>
    </div>
  </div>
</nav>

