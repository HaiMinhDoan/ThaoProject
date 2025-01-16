<template lang="">

    <Preloader/>
    <!-- Header Section Begin -->
    <HeaderSession/>
    <!-- Header End -->

    <!-- Normal Breadcrumb Begin -->
    <section class="normal-breadcrumb" style="background-image: url(src/assets/img/normal-breadcrumb.jpg)">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="normal__breadcrumb__text">
                        <h2>Login</h2>
                        <p>Welcome to the official Anime blog.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->

    <!-- Login Section Begin -->
    <section class="login spad" style="background:#070720">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="login__form">
                        <h3>Login</h3>
                        <form action="#">
                            <span class="text-danger" v-if="true">*{{errorEmailMsg}}</span>
                            <div class="input__item">
                                <input type="text" placeholder="Email address" v-model="email">
                                <span class="icon_mail"></span>
                            </div>
                            <span class="text-danger" v-if="true">*{{errorPasswordMsg}}</span>
                            <div class="input__item">
                                <input type="text" placeholder="Password" v-model="password">
                                <span class="icon_lock"></span>
                            </div>
                            <button type="button" v-on:click="login" class="site-btn">Login Now</button>
                        </form>
                        <a href="#" class="forget_pass">Forgot Your Password?</a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="login__register">
                        <h3>Dont’t Have An Account?</h3>
                        <a href="#" class="primary-btn">Register Now</a>
                    </div>
                </div>
            </div>
            <div class="login__social">
                <div class="row d-flex justify-content-center">
                    <div class="col-lg-6">
                        <div class="login__social__links">
                            <span>or</span>
                            <ul>
                                <li><a href="#" class="facebook"><i class="fa fa-facebook"></i> Sign in With
                                Facebook</a></li>
                                <li><a href="#" class="google"><i class="fa fa-google"></i> Sign in With Google</a></li>
                                <li><a href="#" class="twitter"><i class="fa fa-twitter"></i> Sign in With Twitter</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Login Section End -->

    <!-- Footer Section Begin -->
    <FooterSession/>
      <!-- Footer Section End -->

    <!-- Js Plugins -->
</template>
<script setup>
import HeaderSession from './HeaderSession.vue'
import FooterSession from './FooterSession.vue'
import Preloader from './Preloader.vue';
import { ref, onMounted } from 'vue'
import { preloaderFunc,initSearchModel,initNavigation } from '../assets/js/main';

const email = ref('');
const password = ref('');
const errorEmailMsg = ref('');
const errorPasswordMsg = ref('');
const deviceInfo = ref('');

const tokenCheck = ref(localStorage.getItem('token') ? JSON.parse(localStorage.getItem('token')) : null);
if (tokenCheck.value) {
    window.location.href = '/';
}

// lấy thông tin thiết bị, thông tin trình duyệt, địa chỉ ip
const getDeviceInfo = () => {
    deviceInfo.value = navigator.userAgent;
    console.log(deviceInfo.value);
}
getDeviceInfo();
const login = async () => {
    let loginData = {
        email: email.value,
        password: password.value,
        deviceInfo: deviceInfo.value
    };
    let error = false;
    if (loginData.email === '') {
        errorEmailMsg.value = 'Email không được để trống';
        error = true;
    } else {
        errorEmailMsg.value = '';
    }
    if (loginData.password === '') {
        errorPasswordMsg.value = 'Mật khẩu không được để trống';
        error = true;
    } else {
        errorPasswordMsg.value = '';
    }
    if (error) {
        return;
    }
    // Call API login
    try {
        let response = await fetch('http://localhost:8080/user/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(loginData)
        });
        if (!response.ok) {
            let error = await response.json();
            console.log(error);
            return;
        }
        let data = await response.json();
        window.localStorage.setItem('token', JSON.stringify(data.data));
        console.log(data);
        window.location.href = '/';

    } catch (error) {
        console.log(error);
    }

}
onMounted(() => {
    preloaderFunc();
    initSearchModel();
    
})
</script>
<style lang="">

</style>