<template>
    <div v-if="loadDataDone" class="wrapper">
        <!-- Sidebar -->
        <div class="sidebar" data-background-color="dark">
            <div class="sidebar-logo">
                <!-- Logo Header -->
                <div class="logo-header" data-background-color="dark">
                    <a href="../index.html" class="logo">
                        <img src="../assets2/img/kaiadmin/logo_light.svg" alt="navbar brand" class="navbar-brand"
                            height="20" />
                    </a>
                    <div class="nav-toggle">
                        <button class="btn btn-toggle toggle-sidebar">
                            <i class="gg-menu-right"></i>
                        </button>
                        <button class="btn btn-toggle sidenav-toggler">
                            <i class="gg-menu-left"></i>
                        </button>
                    </div>
                    <button class="topbar-toggler more">
                        <i class="gg-more-vertical-alt"></i>
                    </button>
                </div>
                <!-- End Logo Header -->
            </div>
            <div class="sidebar-wrapper scrollbar scrollbar-inner">
                <div class="sidebar-content">
                    <ul class="nav nav-secondary">
                        <li class="nav-item">
                            <a data-bs-toggle="collapse" href="#dashboard" class="collapsed" aria-expanded="false">
                                <i class="fas fa-home"></i>
                                <p>Dashboard</p>
                                <span class="caret"></span>
                            </a>
                            <div class="collapse" id="dashboard">
                                <ul class="nav nav-collapse">
                                    <li>
                                        <a href="../../demo1/index.html">
                                            <span class="sub-item">Dashboard 1</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-section">
                            <span class="sidebar-mini-icon">
                                <i class="fa fa-ellipsis-h"></i>
                            </span>
                            <h4 class="text-section">Components</h4>
                        </li>
                        <li class="nav-item">
                            <a data-bs-toggle="collapse" href="#base">
                                <i class="fas fa-layer-group"></i>
                                <p>Base</p>
                                <span class="caret"></span>
                            </a>
                            <div class="collapse" id="base">
                                <ul class="nav nav-collapse">
                                    <li>
                                        <a href="../components/avatars.html">
                                            <span class="sub-item">Avatars</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../components/buttons.html">
                                            <span class="sub-item">Buttons</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../components/gridsystem.html">
                                            <span class="sub-item">Grid System</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../components/panels.html">
                                            <span class="sub-item">Panels</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../components/notifications.html">
                                            <span class="sub-item">Notifications</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../components/sweetalert.html">
                                            <span class="sub-item">Sweet Alert</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../components/font-awesome-icons.html">
                                            <span class="sub-item">Font Awesome Icons</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../components/simple-line-icons.html">
                                            <span class="sub-item">Simple Line Icons</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../components/typography.html">
                                            <span class="sub-item">Typography</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a data-bs-toggle="collapse" href="#sidebarLayouts">
                                <i class="fas fa-th-list"></i>
                                <p>Sidebar Layouts</p>
                                <span class="caret"></span>
                            </a>
                            <div class="collapse" id="sidebarLayouts">
                                <ul class="nav nav-collapse">
                                    <li>
                                        <a href="../sidebar-style-2.html">
                                            <span class="sub-item">Sidebar Style 2</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../icon-menu.html">
                                            <span class="sub-item">Icon Menu</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a data-bs-toggle="collapse" href="#forms">
                                <i class="fas fa-pen-square"></i>
                                <p>Forms</p>
                                <span class="caret"></span>
                            </a>
                            <div class="collapse" id="forms">
                                <ul class="nav nav-collapse">
                                    <li>
                                        <a href="../forms/forms.html">
                                            <span class="sub-item">Basic Form</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item active submenu">
                            <a data-bs-toggle="collapse" href="#tables">
                                <i class="fas fa-table"></i>
                                <p>Tables</p>
                                <span class="caret"></span>
                            </a>
                            <div class="collapse show" id="tables">
                                <ul class="nav nav-collapse">
                                    <li>
                                        <a href="../tables/tables.html">
                                            <span class="sub-item">Basic Table</span>
                                        </a>
                                    </li>
                                    <li class="active">
                                        <a href="../tables/datatables.html">
                                            <span class="sub-item">Datatables</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a data-bs-toggle="collapse" href="#maps">
                                <i class="fas fa-map-marker-alt"></i>
                                <p>Maps</p>
                                <span class="caret"></span>
                            </a>
                            <div class="collapse" id="maps">
                                <ul class="nav nav-collapse">
                                    <li>
                                        <a href="../maps/googlemaps.html">
                                            <span class="sub-item">Google Maps</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../maps/jsvectormap.html">
                                            <span class="sub-item">Jsvectormap</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a data-bs-toggle="collapse" href="#charts">
                                <i class="far fa-chart-bar"></i>
                                <p>Charts</p>
                                <span class="caret"></span>
                            </a>
                            <div class="collapse" id="charts">
                                <ul class="nav nav-collapse">
                                    <li>
                                        <a href="../charts/charts.html">
                                            <span class="sub-item">Chart Js</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="../charts/sparkline.html">
                                            <span class="sub-item">Sparkline</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a href="../widgets.html">
                                <i class="fas fa-desktop"></i>
                                <p>Widgets</p>
                                <span class="badge badge-success">4</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="../../../documentation/index.html">
                                <i class="fas fa-file"></i>
                                <p>Documentation</p>
                                <span class="badge badge-secondary">1</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a data-bs-toggle="collapse" href="#submenu">
                                <i class="fas fa-bars"></i>
                                <p>Menu Levels</p>
                                <span class="caret"></span>
                            </a>
                            <div class="collapse" id="submenu">
                                <ul class="nav nav-collapse">
                                    <li>
                                        <a data-bs-toggle="collapse" href="#subnav1">
                                            <span class="sub-item">Level 1</span>
                                            <span class="caret"></span>
                                        </a>
                                        <div class="collapse" id="subnav1">
                                            <ul class="nav nav-collapse subnav">
                                                <li>
                                                    <a href="#">
                                                        <span class="sub-item">Level 2</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="#">
                                                        <span class="sub-item">Level 2</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li>
                                        <a data-bs-toggle="collapse" href="#subnav2">
                                            <span class="sub-item">Level 1</span>
                                            <span class="caret"></span>
                                        </a>
                                        <div class="collapse" id="subnav2">
                                            <ul class="nav nav-collapse subnav">
                                                <li>
                                                    <a href="#">
                                                        <span class="sub-item">Level 2</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <span class="sub-item">Level 1</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- End Sidebar -->

        <div class="main-panel">
            <div class="main-header">
                <div class="main-header-logo">
                    <!-- Logo Header -->
                    <div class="logo-header" data-background-color="dark">
                        <a href="../index.html" class="logo">
                            <img src="../assets/img/kaiadmin/logo_light.svg" alt="navbar brand" class="navbar-brand"
                                height="20" />
                        </a>
                        <div class="nav-toggle">
                            <button class="btn btn-toggle toggle-sidebar">
                                <i class="gg-menu-right"></i>
                            </button>
                            <button class="btn btn-toggle sidenav-toggler">
                                <i class="gg-menu-left"></i>
                            </button>
                        </div>
                        <button class="topbar-toggler more">
                            <i class="gg-more-vertical-alt"></i>
                        </button>
                    </div>
                    <!-- End Logo Header -->
                </div>
                <!-- Navbar Header -->
                <nav class="navbar navbar-header navbar-header-transparent navbar-expand-lg border-bottom">
                    <div class="container-fluid">
                        <nav
                            class="navbar navbar-header-left navbar-expand-lg navbar-form nav-search p-0 d-none d-lg-flex">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <button type="submit" class="btn btn-search pe-1">
                                        <i class="fa fa-search search-icon"></i>
                                    </button>
                                </div>
                                <input type="text" placeholder="Search ..." class="form-control" />
                            </div>
                        </nav>

                        <ul class="navbar-nav topbar-nav ms-md-auto align-items-center">
                            <li class="nav-item topbar-icon dropdown hidden-caret d-flex d-lg-none">
                                <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                                    aria-expanded="false" aria-haspopup="true">
                                    <i class="fa fa-search"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-search animated fadeIn">
                                    <form class="navbar-left navbar-form nav-search">
                                        <div class="input-group">
                                            <input type="text" placeholder="Search ..." class="form-control" />
                                        </div>
                                    </form>
                                </ul>
                            </li>
                            <li class="nav-item topbar-icon dropdown hidden-caret">
                                <a class="nav-link dropdown-toggle" href="#" id="messageDropdown" role="button"
                                    data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-envelope"></i>
                                </a>
                                <ul class="dropdown-menu messages-notif-box animated fadeIn"
                                    aria-labelledby="messageDropdown">
                                    <li>
                                        <div class="dropdown-title d-flex justify-content-between align-items-center">
                                            Messages
                                            <a href="#" class="small">Mark all as read</a>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="message-notif-scroll scrollbar-outer">
                                            <div class="notif-center">
                                                <a href="#">
                                                    <div class="notif-img">
                                                        <img src="../assets/img/jm_denis.jpg" alt="Img Profile" />
                                                    </div>
                                                    <div class="notif-content">
                                                        <span class="subject">Jimmy Denis</span>
                                                        <span class="block"> How are you ? </span>
                                                        <span class="time">5 minutes ago</span>
                                                    </div>
                                                </a>
                                                <a href="#">
                                                    <div class="notif-img">
                                                        <img src="../assets/img/chadengle.jpg" alt="Img Profile" />
                                                    </div>
                                                    <div class="notif-content">
                                                        <span class="subject">Chad</span>
                                                        <span class="block"> Ok, Thanks ! </span>
                                                        <span class="time">12 minutes ago</span>
                                                    </div>
                                                </a>
                                                <a href="#">
                                                    <div class="notif-img">
                                                        <img src="../assets/img/mlane.jpg" alt="Img Profile" />
                                                    </div>
                                                    <div class="notif-content">
                                                        <span class="subject">Jhon Doe</span>
                                                        <span class="block">
                                                            Ready for the meeting today...
                                                        </span>
                                                        <span class="time">12 minutes ago</span>
                                                    </div>
                                                </a>
                                                <a href="#">
                                                    <div class="notif-img">
                                                        <img src="../assets/img/talha.jpg" alt="Img Profile" />
                                                    </div>
                                                    <div class="notif-content">
                                                        <span class="subject">Talha</span>
                                                        <span class="block"> Hi, Apa Kabar ? </span>
                                                        <span class="time">17 minutes ago</span>
                                                    </div>
                                                </a>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a class="see-all" href="javascript:void(0);">See all messages<i
                                                class="fa fa-angle-right"></i>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item topbar-icon dropdown hidden-caret">
                                <a class="nav-link dropdown-toggle" href="#" id="notifDropdown" role="button"
                                    data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-bell"></i>
                                    <span class="notification">4</span>
                                </a>
                                <ul class="dropdown-menu notif-box animated fadeIn" aria-labelledby="notifDropdown">
                                    <li>
                                        <div class="dropdown-title">
                                            You have 4 new notification
                                        </div>
                                    </li>
                                    <li>
                                        <div class="notif-scroll scrollbar-outer">
                                            <div class="notif-center">
                                                <a href="#">
                                                    <div class="notif-icon notif-primary">
                                                        <i class="fa fa-user-plus"></i>
                                                    </div>
                                                    <div class="notif-content">
                                                        <span class="block"> New user registered </span>
                                                        <span class="time">5 minutes ago</span>
                                                    </div>
                                                </a>
                                                <a href="#">
                                                    <div class="notif-icon notif-success">
                                                        <i class="fa fa-comment"></i>
                                                    </div>
                                                    <div class="notif-content">
                                                        <span class="block">
                                                            Rahmad commented on Admin
                                                        </span>
                                                        <span class="time">12 minutes ago</span>
                                                    </div>
                                                </a>
                                                <a href="#">
                                                    <div class="notif-img">
                                                        <img src="../assets/img/profile2.jpg" alt="Img Profile" />
                                                    </div>
                                                    <div class="notif-content">
                                                        <span class="block">
                                                            Reza send messages to you
                                                        </span>
                                                        <span class="time">12 minutes ago</span>
                                                    </div>
                                                </a>
                                                <a href="#">
                                                    <div class="notif-icon notif-danger">
                                                        <i class="fa fa-heart"></i>
                                                    </div>
                                                    <div class="notif-content">
                                                        <span class="block"> Farrah liked Admin </span>
                                                        <span class="time">17 minutes ago</span>
                                                    </div>
                                                </a>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a class="see-all" href="javascript:void(0);">See all notifications<i
                                                class="fa fa-angle-right"></i>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item topbar-icon dropdown hidden-caret">
                                <a class="nav-link" data-bs-toggle="dropdown" href="#" aria-expanded="false">
                                    <i class="fas fa-layer-group"></i>
                                </a>
                                <div class="dropdown-menu quick-actions animated fadeIn">
                                    <div class="quick-actions-header">
                                        <span class="title mb-1">Quick Actions</span>
                                        <span class="subtitle op-7">Shortcuts</span>
                                    </div>
                                    <div class="quick-actions-scroll scrollbar-outer">
                                        <div class="quick-actions-items">
                                            <div class="row m-0">
                                                <a class="col-6 col-md-4 p-0" href="#">
                                                    <div class="quick-actions-item">
                                                        <div class="avatar-item bg-danger rounded-circle">
                                                            <i class="far fa-calendar-alt"></i>
                                                        </div>
                                                        <span class="text">Calendar</span>
                                                    </div>
                                                </a>
                                                <a class="col-6 col-md-4 p-0" href="#">
                                                    <div class="quick-actions-item">
                                                        <div class="avatar-item bg-warning rounded-circle">
                                                            <i class="fas fa-map"></i>
                                                        </div>
                                                        <span class="text">Maps</span>
                                                    </div>
                                                </a>
                                                <a class="col-6 col-md-4 p-0" href="#">
                                                    <div class="quick-actions-item">
                                                        <div class="avatar-item bg-info rounded-circle">
                                                            <i class="fas fa-file-excel"></i>
                                                        </div>
                                                        <span class="text">Reports</span>
                                                    </div>
                                                </a>
                                                <a class="col-6 col-md-4 p-0" href="#">
                                                    <div class="quick-actions-item">
                                                        <div class="avatar-item bg-success rounded-circle">
                                                            <i class="fas fa-envelope"></i>
                                                        </div>
                                                        <span class="text">Emails</span>
                                                    </div>
                                                </a>
                                                <a class="col-6 col-md-4 p-0" href="#">
                                                    <div class="quick-actions-item">
                                                        <div class="avatar-item bg-primary rounded-circle">
                                                            <i class="fas fa-file-invoice-dollar"></i>
                                                        </div>
                                                        <span class="text">Invoice</span>
                                                    </div>
                                                </a>
                                                <a class="col-6 col-md-4 p-0" href="#">
                                                    <div class="quick-actions-item">
                                                        <div class="avatar-item bg-secondary rounded-circle">
                                                            <i class="fas fa-credit-card"></i>
                                                        </div>
                                                        <span class="text">Payments</span>
                                                    </div>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>

                            <li class="nav-item topbar-user dropdown hidden-caret">
                                <a class="dropdown-toggle profile-pic" data-bs-toggle="dropdown" href="#"
                                    aria-expanded="false">
                                    <div class="avatar-sm">
                                        <img src="../assets2/img/profile.jpg" alt="..."
                                            class="avatar-img rounded-circle" />
                                    </div>
                                    <span class="profile-username">
                                        <span class="op-7">Hi,</span>
                                        <span class="fw-bold">Hizrian</span>
                                    </span>
                                </a>
                                <ul class="dropdown-menu dropdown-user animated fadeIn">
                                    <div class="dropdown-user-scroll scrollbar-outer">
                                        <li>
                                            <div class="user-box">
                                                <div class="avatar-lg">
                                                    <img src="../assets/img/profile.jpg" alt="image profile"
                                                        class="avatar-img rounded" />
                                                </div>
                                                <div class="u-text">
                                                    <h4>Hizrian</h4>
                                                    <p class="text-muted">hello@example.com</p>
                                                    <a href="profile.html" class="btn btn-xs btn-secondary btn-sm">View
                                                        Profile</a>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="#">My Profile</a>
                                            <a class="dropdown-item" href="#">My Balance</a>
                                            <a class="dropdown-item" href="#">Inbox</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="#">Account Setting</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="#">Logout</a>
                                        </li>
                                    </div>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </nav>
                <!-- End Navbar -->
            </div>

            <div class="container">
                <div class="page-inner">
                    <div class="page-header">

                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <div class="d-flex align-items-center">
                                        <h4 class="card-title">Quản lý phim</h4>
                                        <button class="btn btn-primary btn-round ms-auto" data-bs-toggle="modal"
                                            data-bs-target="#addRowModal">
                                            <i class="fa fa-plus"></i>
                                            Add Row
                                        </button>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table id="multi-filter-select" class="display table table-striped table-hover">
                                            <thead>
                                                <tr>
                                                    <th>Tên</th>
                                                    <th>Tên quốc tế</th>
                                                    <th>Thời lượng</th>
                                                    <td>Chất lượng</td>
                                                    <th>Năm ra mắt</th>
                                                    <th>Thể loại</th>
                                                    <th>Lượt bình luận</th>
                                                    <th>Votes</th>
                                                </tr>
                                            </thead>
                                            <tfoot>
                                                <tr>
                                                    <th>Tên</th>
                                                    <th>Tên quốc tế</th>
                                                    <th>Thời lượng</th>
                                                    <td>Chất lượng</td>
                                                    <th>Năm ra mắt</th>
                                                    <th>Thể loại</th>
                                                    <th>Lượt bình luận</th>
                                                    <th>Votes</th>
                                                </tr>
                                            </tfoot>
                                            <tbody>
                                                <tr v-for="(film, index) in dataGroup1" :key="film.id">
                                                    <td>{{ film.title }}</td>
                                                    <td>{{ film.japaneseTitle }}</td>
                                                    <td>{{ film.duration }}</td>
                                                    <td>{{ film.quality }}</td>
                                                    <td>{{ film.publishYear }}</td>
                                                    <td>
                                                        <template v-for="(genre,genreIndex) in film.genres">
                                                            {{genre.name}}&nbsp;
                                                        </template>
                                                    </td>
                                                    <td>{{ film.ratings.length }}</td>
                                                    <td>{{ film.comments.length }}</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <div class="d-flex align-items-center">
                                        <h4 class="card-title">Quản lý người dùng</h4>
                                        <button class="btn btn-primary btn-round ms-auto" data-bs-toggle="modal"
                                            data-bs-target="#addRowModal">
                                            <i class="fa fa-plus"></i>
                                            Add Row
                                        </button>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <!-- Modal -->
                                    <div class="modal fade" id="addRowModal" tabindex="-1" role="dialog"
                                        aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header border-0">
                                                    <h5 class="modal-title">
                                                        <span class="fw-mediumbold"> New</span>
                                                        <span class="fw-light"> Row </span>
                                                    </h5>
                                                    <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <p class="small">
                                                        Create a new row using this form, make sure you
                                                        fill them all
                                                    </p>
                                                    <form>
                                                        <div class="row">
                                                            <div class="col-sm-12">
                                                                <div class="form-group form-group-default">
                                                                    <label>Name</label>
                                                                    <input id="addName" type="text" class="form-control"
                                                                        placeholder="fill name" />
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6 pe-0">
                                                                <div class="form-group form-group-default">
                                                                    <label>Position</label>
                                                                    <input id="addPosition" type="text"
                                                                        class="form-control"
                                                                        placeholder="fill position" />
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="form-group form-group-default">
                                                                    <label>Office</label>
                                                                    <input id="addOffice" type="text"
                                                                        class="form-control"
                                                                        placeholder="fill office" />
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="modal-footer border-0">
                                                    <button type="button" id="addRowButton" class="btn btn-primary">
                                                        Add
                                                    </button>
                                                    <button type="button" class="btn btn-danger" data-dismiss="modal">
                                                        Close
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="table-responsive">
                                        <table id="add-row" class="display table table-striped table-hover">
                                            <thead>
                                                <tr>
                                                    <th>Name</th>
                                                    <th>Email</th>
                                                    <th>Quyền hạn</th>
                                                    <th style="width: 10%">Sửa/Xóa</th>
                                                </tr>
                                            </thead>
                                            <tfoot>
                                                <tr>
                                                    <th>Name</th>
                                                    <th>Email</th>
                                                    <th>Quyền hạn</th>
                                                    <th>Sửa/Xóa</th>
                                                </tr>
                                            </tfoot>
                                            <tbody>
                                                <tr>
                                                    <td>Tiger Nixon</td>
                                                    <td>bunbun@gmail.com</td>
                                                    <td>Customer</td>
                                                    <td>
                                                        <div class="form-button-action">
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-primary btn-lg"
                                                                data-original-title="Edit Task">
                                                                <i class="fa fa-edit"></i>
                                                            </button>
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-danger"
                                                                data-original-title="Remove">
                                                                <i class="fa fa-times"></i>
                                                            </button>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Garrett Winters</td>
                                                    <td>bunbun@gmail.com</td>
                                                    <td>Customer</td>
                                                    <td>
                                                        <div class="form-button-action">
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-primary btn-lg"
                                                                data-original-title="Edit Task">
                                                                <i class="fa fa-edit"></i>
                                                            </button>
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-danger"
                                                                data-original-title="Remove">
                                                                <i class="fa fa-times"></i>
                                                            </button>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Ashton Cox</td>
                                                    <td>bunbun@gmail.com</td>
                                                    <td>Customer</td>
                                                    <td>
                                                        <div class="form-button-action">
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-primary btn-lg"
                                                                data-original-title="Edit Task">
                                                                <i class="fa fa-edit"></i>
                                                            </button>
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-danger"
                                                                data-original-title="Remove">
                                                                <i class="fa fa-times"></i>
                                                            </button>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Cedric Kelly</td>
                                                    <td>bunbun@gmail.com</td>
                                                    <td>Customer</td>
                                                    <td>
                                                        <div class="form-button-action">
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-primary btn-lg"
                                                                data-original-title="Edit Task">
                                                                <i class="fa fa-edit"></i>
                                                            </button>
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-danger"
                                                                data-original-title="Remove">
                                                                <i class="fa fa-times"></i>
                                                            </button>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Airi Satou</td>
                                                    <td>bunbun@gmail.com</td>
                                                    <td>Customer</td>
                                                    <td>
                                                        <div class="form-button-action">
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-primary btn-lg"
                                                                data-original-title="Edit Task">
                                                                <i class="fa fa-edit"></i>
                                                            </button>
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-danger"
                                                                data-original-title="Remove">
                                                                <i class="fa fa-times"></i>
                                                            </button>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Brielle Williamson</td>
                                                    <td>bunbun@gmail.com</td>
                                                    <td>Customer</td>
                                                    <td>
                                                        <div class="form-button-action">
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-primary btn-lg"
                                                                data-original-title="Edit Task">
                                                                <i class="fa fa-edit"></i>
                                                            </button>
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-danger"
                                                                data-original-title="Remove">
                                                                <i class="fa fa-times"></i>
                                                            </button>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Herrod Chandler</td>
                                                    <td>bunbun@gmail.com</td>
                                                    <td>Customer</td>
                                                    <td>
                                                        <div class="form-button-action">
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-primary btn-lg"
                                                                data-original-title="Edit Task">
                                                                <i class="fa fa-edit"></i>
                                                            </button>
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-danger"
                                                                data-original-title="Remove">
                                                                <i class="fa fa-times"></i>
                                                            </button>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Rhona Davidson</td>
                                                    <td>bunbun@gmail.com</td>
                                                    <td>Customer</td>
                                                    <td>
                                                        <div class="form-button-action">
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-primary btn-lg"
                                                                data-original-title="Edit Task">
                                                                <i class="fa fa-edit"></i>
                                                            </button>
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-danger"
                                                                data-original-title="Remove">
                                                                <i class="fa fa-times"></i>
                                                            </button>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Colleen Hurst</td>
                                                    <td>bunbun@gmail.com</td>
                                                    <td>Customer</td>
                                                    <td>
                                                        <div class="form-button-action">
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-primary btn-lg"
                                                                data-original-title="Edit Task">
                                                                <i class="fa fa-edit"></i>
                                                            </button>
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-danger"
                                                                data-original-title="Remove">
                                                                <i class="fa fa-times"></i>
                                                            </button>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Sonya Frost</td>
                                                    <td>bunbun@gmail.com</td>
                                                    <td>Customer</td>
                                                    <td>
                                                        <div class="form-button-action">
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-primary btn-lg"
                                                                data-original-title="Edit Task">
                                                                <i class="fa fa-edit"></i>
                                                            </button>
                                                            <button type="button" data-bs-toggle="tooltip" title=""
                                                                class="btn btn-link btn-danger"
                                                                data-original-title="Remove">
                                                                <i class="fa fa-times"></i>
                                                            </button>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <footer class="footer">
                <div class="container-fluid d-flex justify-content-between">
                    <nav class="pull-left">
                        <ul class="nav">
                            <li class="nav-item">
                                <a class="nav-link" href="http://www.themekita.com">
                                    ThemeKita
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#"> Help </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#"> Licenses </a>
                            </li>
                        </ul>
                    </nav>
                    <div class="copyright">
                        2024, made with <i class="fa fa-heart heart text-danger"></i> by
                        <a href="http://www.themekita.com">ThemeKita</a>
                    </div>
                    <div>
                        Distributed by
                        <a target="_blank" href="https://themewagon.com/">ThemeWagon</a>.
                    </div>
                </div>
            </footer>
        </div>

        <!-- Custom template | don't include it in your project! -->
        <div class="custom-template">
            <div class="title">Settings</div>
            <div class="custom-content">
                <div class="switcher">
                    <div class="switch-block">
                        <h4>Logo Header</h4>
                        <div class="btnSwitch">
                            <button type="button" class="selected changeLogoHeaderColor" data-color="dark"></button>
                            <button type="button" class="selected changeLogoHeaderColor" data-color="blue"></button>
                            <button type="button" class="changeLogoHeaderColor" data-color="purple"></button>
                            <button type="button" class="changeLogoHeaderColor" data-color="light-blue"></button>
                            <button type="button" class="changeLogoHeaderColor" data-color="green"></button>
                            <button type="button" class="changeLogoHeaderColor" data-color="orange"></button>
                            <button type="button" class="changeLogoHeaderColor" data-color="red"></button>
                            <button type="button" class="changeLogoHeaderColor" data-color="white"></button>
                            <br />
                            <button type="button" class="changeLogoHeaderColor" data-color="dark2"></button>
                            <button type="button" class="changeLogoHeaderColor" data-color="blue2"></button>
                            <button type="button" class="changeLogoHeaderColor" data-color="purple2"></button>
                            <button type="button" class="changeLogoHeaderColor" data-color="light-blue2"></button>
                            <button type="button" class="changeLogoHeaderColor" data-color="green2"></button>
                            <button type="button" class="changeLogoHeaderColor" data-color="orange2"></button>
                            <button type="button" class="changeLogoHeaderColor" data-color="red2"></button>
                        </div>
                    </div>
                    <div class="switch-block">
                        <h4>Navbar Header</h4>
                        <div class="btnSwitch">
                            <button type="button" class="changeTopBarColor" data-color="dark"></button>
                            <button type="button" class="changeTopBarColor" data-color="blue"></button>
                            <button type="button" class="changeTopBarColor" data-color="purple"></button>
                            <button type="button" class="changeTopBarColor" data-color="light-blue"></button>
                            <button type="button" class="changeTopBarColor" data-color="green"></button>
                            <button type="button" class="changeTopBarColor" data-color="orange"></button>
                            <button type="button" class="changeTopBarColor" data-color="red"></button>
                            <button type="button" class="changeTopBarColor" data-color="white"></button>
                            <br />
                            <button type="button" class="changeTopBarColor" data-color="dark2"></button>
                            <button type="button" class="selected changeTopBarColor" data-color="blue2"></button>
                            <button type="button" class="changeTopBarColor" data-color="purple2"></button>
                            <button type="button" class="changeTopBarColor" data-color="light-blue2"></button>
                            <button type="button" class="changeTopBarColor" data-color="green2"></button>
                            <button type="button" class="changeTopBarColor" data-color="orange2"></button>
                            <button type="button" class="changeTopBarColor" data-color="red2"></button>
                        </div>
                    </div>
                    <div class="switch-block">
                        <h4>Sidebar</h4>
                        <div class="btnSwitch">
                            <button type="button" class="selected changeSideBarColor" data-color="white"></button>
                            <button type="button" class="changeSideBarColor" data-color="dark"></button>
                            <button type="button" class="changeSideBarColor" data-color="dark2"></button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="custom-toggle" id="testId">
                <i class="icon-settings"></i>
            </div>
        </div>
        <!-- End Custom template -->
    </div>
</template>

<script setup>
import { onMounted, ref } from 'vue';
const loadDataDone = ref(false);
const dataGroup1 = ref([]);
const dataGroup2 = ref([]);
const loadData = async () => {
    loadDataDone.value = false;
    const response1 = await fetch(`http://localhost:8080/theater/film/all`);

    if (response1.ok) {
        const data1 = await response1.json();
        dataGroup1.value = data1.data;
    }
    loadDataDone.value = true;
}
onMounted(async () => {
    await loadData();
    'use strict'

    // Setting Color

    $(window).resize(function () {
        $(window).width()
    })

    getCheckmark()
    console.log('hehe')

    var toggle_customSidebar = false;
    var custom_open = 0

    var toggle = $('.custom-template .custom-toggle')
    // var toggle = $('#testId')
    console.log(toggle)

    toggle.on('click', function () {
        console.log('hhe')
        if (custom_open == 1) {
            $('.custom-template').removeClass('open')
            toggle.removeClass('toggled')
            custom_open = 0
        } else {
            $('.custom-template').addClass('open')
            toggle.addClass('toggled')
            custom_open = 1
        }
    })
    toggle_customSidebar = true

    $('.changeBodyBackgroundFullColor').on('click', function () {
        if ($(this).attr('data-color') == 'default') {
            $('body').removeAttr('data-background-full')
        } else {
            $('body').attr('data-background-full', $(this).attr('data-color'))
        }

        $(this).parent().find('.changeBodyBackgroundFullColor').removeClass('selected')
        $(this).addClass('selected')
        layoutsColors()
        getCheckmark()
    })

    $('.changeLogoHeaderColor').on('click', function () {
        if ($(this).attr('data-color') == 'default') {
            $('.logo-header').removeAttr('data-background-color')
        } else {
            $('.logo-header').attr('data-background-color', $(this).attr('data-color'))
        }

        $(this).parent().find('.changeLogoHeaderColor').removeClass('selected')
        $(this).addClass('selected')
        customCheckColor()
        layoutsColors()
        getCheckmark()
    })

    $('.changeTopBarColor').on('click', function () {
        if ($(this).attr('data-color') == 'default') {
            $('.main-header .navbar-header').removeAttr('data-background-color')
        } else {
            $('.main-header .navbar-header').attr('data-background-color', $(this).attr('data-color'))
        }

        $(this).parent().find('.changeTopBarColor').removeClass('selected')
        $(this).addClass('selected')
        layoutsColors()
        getCheckmark()
    })

    $('.changeSideBarColor').on('click', function () {
        if ($(this).attr('data-color') == 'default') {
            $('.sidebar').removeAttr('data-background-color')
        } else {
            $('.sidebar').attr('data-background-color', $(this).attr('data-color'))
        }

        $(this).parent().find('.changeSideBarColor').removeClass('selected')
        $(this).addClass('selected')
        layoutsColors()
        getCheckmark()
    })

    $('.changeBackgroundColor').on('click', function () {
        $('body').removeAttr('data-background-color')
        $('body').attr('data-background-color', $(this).attr('data-color'))
        $(this).parent().find('.changeBackgroundColor').removeClass('selected')
        $(this).addClass('selected')
        getCheckmark()
    })

    function customCheckColor() {
        var logoHeader = $('.logo-header').attr('data-background-color')
        if (logoHeader !== 'white') {
            $('.logo-header .navbar-brand').attr('src', 'src/assets2/img/kaiadmin/logo_light.svg')
        } else {
            $('.logo-header .navbar-brand').attr('src', 'src/assets2/img/kaiadmin/logo_dark.svg')
        }
    }

    function getCheckmark() {
        var checkmark = `<i class="gg-check"></i>`
        $('.btnSwitch').find('button').empty()
        $('.btnSwitch').find('button.selected').append(checkmark)
    }
    $(document).ready(function () {
        $('#basic-datatables').DataTable({})

        $('#multi-filter-select').DataTable({
            pageLength: 5,
            initComplete: function () {
                this.api()
                    .columns()
                    .every(function () {
                        var column = this
                        var select = $('<select class="form-select"><option value=""></option></select>')
                            .appendTo($(column.footer()).empty())
                            .on('change', function () {
                                var val = $.fn.dataTable.util.escapeRegex($(this).val())

                                column.search(val ? '^' + val + '$' : '', true, false).draw()
                            })

                        column
                            .data()
                            .unique()
                            .sort()
                            .each(function (d, j) {
                                select.append('<option value="' + d + '">' + d + '</option>')
                            })
                    })
            },
        })

        // Add Row
        $('#add-row').DataTable({
            pageLength: 5,
        })

        var action =
            '<td> <div class="form-button-action"> <button type="button" data-bs-toggle="tooltip" title="" class="btn btn-link btn-primary btn-lg" data-original-title="Edit Task"> <i class="fa fa-edit"></i> </button> <button type="button" data-bs-toggle="tooltip" title="" class="btn btn-link btn-danger" data-original-title="Remove"> <i class="fa fa-times"></i> </button> </div> </td>'

        $('#addRowButton').click(function () {
            $('#add-row')
                .dataTable()
                .fnAddData([$('#addName').val(), $('#addPosition').val(), $('#addOffice').val(), action])
            $('#addRowModal').modal('hide')
        })
    })

    var logoHeaderContent = $('.sidebar .logo-header').html();
    $('.main-header .logo-header').html(logoHeaderContent);

    $(".nav-search .input-group > input").focus(function (e) {
        $(this).parents().eq(2).addClass("focus");
    }).blur(function (e) {
        $(this).parents().eq(2).removeClass("focus");
    });

    $(function () {
        // Show Tooltip
        const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]');
        const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl));
        // Show Popover
        const popoverTriggerList = document.querySelectorAll('[data-bs-toggle="popover"]');
        const popoverList = [...popoverTriggerList].map(popoverTriggerEl => new bootstrap.Popover(popoverTriggerEl));
        layoutsColors();
        customBackgroundColor();
    });

    function layoutsColors() {
        if ($('.sidebar').is('[data-background-color]')) {
            $('html').addClass('sidebar-color');
        } else {
            $('html').removeClass('sidebar-color');
        }
    }

    function customBackgroundColor() {
        $('*[data-background-color="custom"]').each(function () {
            if ($(this).is('[custom-color]')) {
                $(this).css('background', $(this).attr('custom-color'));
            } else if ($(this).is('[custom-background]')) {
                $(this).css('background-image', 'url(' + $(this).attr('custom-background') + ')');
            }
        });
    }

    function legendClickCallback(event) {
        event = event || window.event;

        var target = event.target || event.srcElement;
        while (target.nodeName !== 'LI') {
            target = target.parentElement;
        }
        var parent = target.parentElement;
        var chartId = parseInt(parent.classList[0].split("-")[0], 10);
        var chart = Chart.instances[chartId];
        var index = Array.prototype.slice.call(parent.children).indexOf(target);

        chart.legend.options.onClick.call(chart, event, chart.legend.legendItems[index]);
        if (chart.isDatasetVisible(index)) {
            target.classList.remove('hidden');
        } else {
            target.classList.add('hidden');
        }
    }

    $(document).ready(function () {

        $('.btn-refresh-card').on('click', function () { var e = $(this).parents(".card"); e.length && (e.addClass("is-loading"), setTimeout(function () { e.removeClass("is-loading") }, 3e3)) })

        var scrollbarDashboard = $('.sidebar .scrollbar');
        if (scrollbarDashboard.length > 0) {
            scrollbarDashboard.scrollbar();
        }

        var contentScrollbar = $('.main-panel .content-scroll');
        if (contentScrollbar.length > 0) {
            contentScrollbar.scrollbar();
        }

        var messagesScrollbar = $('.messages-scroll');
        if (messagesScrollbar.length > 0) {
            messagesScrollbar.scrollbar();
        }

        var tasksScrollbar = $('.tasks-scroll');
        if (tasksScrollbar.length > 0) {
            tasksScrollbar.scrollbar();
        }

        var quickScrollbar = $('.quick-scroll');
        if (quickScrollbar.length > 0) {
            quickScrollbar.scrollbar();
        }

        var messageNotifScrollbar = $('.message-notif-scroll');
        if (messageNotifScrollbar.length > 0) {
            messageNotifScrollbar.scrollbar();
        }

        var notifScrollbar = $('.notif-scroll');
        if (notifScrollbar.length > 0) {
            notifScrollbar.scrollbar();
        }

        var quickActionsScrollbar = $('.quick-actions-scroll');
        if (quickActionsScrollbar.length > 0) {
            quickActionsScrollbar.scrollbar();
        }

        var userScrollbar = $('.dropdown-user-scroll');
        if (userScrollbar.length > 0) {
            userScrollbar.scrollbar();
        }

        $('#search-nav').on('shown.bs.collapse', function () {
            $('.nav-search .form-control').focus();
        });

        var toggle_sidebar = false,
            toggle_quick_sidebar = false,
            toggle_topbar = false,
            minimize_sidebar = false,
            first_toggle_sidebar = false,
            toggle_page_sidebar = false,
            toggle_overlay_sidebar = false,
            nav_open = 0,
            quick_sidebar_open = 0,
            topbar_open = 0,
            mini_sidebar = 0,
            page_sidebar_open = 0,
            overlay_sidebar_open = 0;


        if (!toggle_sidebar) {
            var toggle = $('.sidenav-toggler');

            toggle.on('click', function () {
                if (nav_open == 1) {
                    $('html').removeClass('nav_open');
                    toggle.removeClass('toggled');
                    nav_open = 0;
                } else {
                    $('html').addClass('nav_open');
                    toggle.addClass('toggled');
                    nav_open = 1;
                }
            });
            toggle_sidebar = true;
        }

        if (!quick_sidebar_open) {
            var toggle = $('.quick-sidebar-toggler');

            toggle.on('click', function () {
                if (nav_open == 1) {
                    $('html').removeClass('quick_sidebar_open');
                    $('.quick-sidebar-overlay').remove();
                    toggle.removeClass('toggled');
                    quick_sidebar_open = 0;
                } else {
                    $('html').addClass('quick_sidebar_open');
                    toggle.addClass('toggled');
                    $('<div class="quick-sidebar-overlay"></div>').insertAfter('.quick-sidebar');
                    quick_sidebar_open = 1;
                }
            });

            $('.wrapper').mouseup(function (e) {
                var subject = $('.quick-sidebar');

                if (e.target.className != subject.attr('class') && !subject.has(e.target).length) {
                    $('html').removeClass('quick_sidebar_open');
                    $('.quick-sidebar-toggler').removeClass('toggled');
                    $('.quick-sidebar-overlay').remove();
                    quick_sidebar_open = 0;
                }
            });

            $(".close-quick-sidebar").on('click', function () {
                $('html').removeClass('quick_sidebar_open');
                $('.quick-sidebar-toggler').removeClass('toggled');
                $('.quick-sidebar-overlay').remove();
                quick_sidebar_open = 0;
            });

            quick_sidebar_open = true;
        }

        if (!toggle_topbar) {
            var topbar = $('.topbar-toggler');

            topbar.on('click', function () {
                if (topbar_open == 1) {
                    $('html').removeClass('topbar_open');
                    topbar.removeClass('toggled');
                    topbar_open = 0;
                } else {
                    $('html').addClass('topbar_open');
                    topbar.addClass('toggled');
                    topbar_open = 1;
                }
            });
            toggle_topbar = true;
        }

        if (!minimize_sidebar) {
            var minibutton = $('.toggle-sidebar');
            if ($('.wrapper').hasClass('sidebar_minimize')) {
                minibutton.addClass('toggled');
                minibutton.html('<i class="gg-more-vertical-alt"></i>');
                mini_sidebar = 1;
            }

            minibutton.on('click', function () {
                if (mini_sidebar == 1) {
                    $('.wrapper').removeClass('sidebar_minimize')
                    minibutton.removeClass('toggled');
                    minibutton.html('<i class="gg-menu-right"></i>');
                    mini_sidebar = 0;
                } else {
                    $('.wrapper').addClass('sidebar_minimize');
                    minibutton.addClass('toggled');
                    minibutton.html('<i class="gg-more-vertical-alt"></i>');
                    mini_sidebar = 1;
                }
                $(window).resize();
            });
            minimize_sidebar = true;
            first_toggle_sidebar = true;
        }

        if (!toggle_page_sidebar) {
            var pageSidebarToggler = $('.page-sidebar-toggler');

            pageSidebarToggler.on('click', function () {
                if (page_sidebar_open == 1) {
                    $('html').removeClass('pagesidebar_open');
                    pageSidebarToggler.removeClass('toggled');
                    page_sidebar_open = 0;
                } else {
                    $('html').addClass('pagesidebar_open');
                    pageSidebarToggler.addClass('toggled');
                    page_sidebar_open = 1;
                }
            });

            var pageSidebarClose = $('.page-sidebar .back');

            pageSidebarClose.on('click', function () {
                $('html').removeClass('pagesidebar_open');
                pageSidebarToggler.removeClass('toggled');
                page_sidebar_open = 0;
            });

            toggle_page_sidebar = true;
        }

        if (!toggle_overlay_sidebar) {
            var overlaybutton = $('.sidenav-overlay-toggler');
            if ($('.wrapper').hasClass('is-show')) {
                overlay_sidebar_open = 1;
                overlaybutton.addClass('toggled');
                overlaybutton.html('<i class="icon-options-vertical"></i>');
            }

            overlaybutton.on('click', function () {
                if (overlay_sidebar_open == 1) {
                    $('.wrapper').removeClass('is-show');
                    overlaybutton.removeClass('toggled');
                    overlaybutton.html('<i class="icon-menu"></i>');
                    overlay_sidebar_open = 0;
                } else {
                    $('.wrapper').addClass('is-show');
                    overlaybutton.addClass('toggled');
                    overlaybutton.html('<i class="icon-options-vertical"></i>');
                    overlay_sidebar_open = 1;
                }
                $(window).resize();
            });
            minimize_sidebar = true;
        }


        $('.sidebar').mouseenter(function () {
            if (mini_sidebar == 1 && !first_toggle_sidebar) {
                $('.wrapper').addClass('sidebar_minimize_hover');
                first_toggle_sidebar = true;
            } else {
                $('.wrapper').removeClass('sidebar_minimize_hover');
            }
        }).mouseleave(function () {
            if (mini_sidebar == 1 && first_toggle_sidebar) {
                $('.wrapper').removeClass('sidebar_minimize_hover');
                first_toggle_sidebar = false;
            }
        });

        // addClass if nav-item click and has subnav

        $(".nav-item a").on('click', (function () {
            if ($(this).parent().find('.collapse').hasClass("show")) {
                $(this).parent().removeClass('submenu');
            } else {
                $(this).parent().addClass('submenu');
            }
        }));


        //Chat Open
        $('.messages-contact .user a').on('click', function () {
            $('.tab-chat').addClass('show-chat')
        });

        $('.messages-wrapper .return').on('click', function () {
            $('.tab-chat').removeClass('show-chat')
        });

        //select all
        $('[data-select="checkbox"]').change(function () {
            var target = $(this).attr('data-target');
            $(target).prop('checked', $(this).prop("checked"));
        })

        //form-group-default active if input focus
        $(".form-group-default .form-control").focus(function () {
            $(this).parent().addClass("active");
        }).blur(function () {
            $(this).parent().removeClass("active");
        })

    });

    // Input File Image

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $(input).parent('.input-file-image').find('.img-upload-preview').attr('src', e.target.result);
            }

            reader.readAsDataURL(input.files[0]);
        }
    }

    $('.input-file-image input[type="file"').change(function () {
        readURL(this);
    });

    // Show Password

    function showPassword(button) {
        var inputPassword = $(button).parent().find('input');
        if (inputPassword.attr('type') === "password") {
            inputPassword.attr('type', 'text');
        } else {
            inputPassword.attr('type', 'password');
        }
    }

    $('.show-password').on('click', function () {
        showPassword(this);
    })

    // Sign In & Sign Up
    var containerSignIn = $('.container-login'),
        containerSignUp = $('.container-signup'),
        showSignIn = true,
        showSignUp = false;

    function changeContainer() {
        if (showSignIn == true) {
            containerSignIn.css('display', 'block')
        } else {
            containerSignIn.css('display', 'none')
        }

        if (showSignUp == true) {
            containerSignUp.css('display', 'block')
        } else {
            containerSignUp.css('display', 'none')
        }
    }

    $('#show-signup').on('click', function () {
        showSignUp = true;
        showSignIn = false;
        changeContainer();
    })

    $('#show-signin').on('click', function () {
        showSignUp = false;
        showSignIn = true;
        changeContainer();
    })

    changeContainer();

    //Input with Floating Label

    $('.form-floating-label .form-control').keyup(function () {
        if ($(this).val() !== '') {
            $(this).addClass('filled');
        } else {
            $(this).removeClass('filled');
        }
    })


});

</script>

<style scoped></style>
