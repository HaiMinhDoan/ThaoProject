<template lang="">
    <!-- Page Preloder -->
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
                        <h2>Sign Up</h2>
                        <p>Welcome to the official Anime blog.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->

    <!-- Signup Section Begin -->
    <section class="signup spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="login__form">
                        <h3>Sign Up</h3>
                        <form action="#" @submit.prevent="register">
                            <span class="text-error" v-if="true">*{{errorEmailMsg}}</span>
                            <div class="input__item">
                                <input type="text" placeholder="Địa chỉ email" v-model="email" required>
                                <span class="icon_mail"></span>
                            </div>
                            <span class="text-error" v-if="true">*{{errorPasswordMsg}}</span>
                            <div class="input__item">
                                <input type="password" placeholder="Mật khẩu" v-model="password" required>
                                <span class="icon_lock"></span>
                            </div>
                            <span class="text-error" v-if="true">*{{errorUsernameMsg}}</span>
                            <div class="input__item">
                                <input type="text" placeholder="Tên người dùng" v-model="username" required>
                                <span class="icon_profile"></span>
                            </div>
                            <button :class="{'disabled-btn':!isAccept}" :disabled="!isAccept" type="button" v-on:click="register()" class="site-btn">Đăng ký</button>
                        </form>
                        <h5>Already have an account? <a href="#">Log In!</a></h5>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="login__social__links">
                        <h3>Login With:</h3>
                        <ul>
                            <li><a href="#" class="facebook"><i class="fa fa-facebook"></i> Sign in With Facebook</a>
                            </li>
                            <li><a href="#" class="google"><i class="fa fa-google"></i> Sign in With Google</a></li>
                            <li><a href="#" class="twitter"><i class="fa fa-twitter"></i> Sign in With Twitter</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Signup Section End -->

    <!-- Footer Section Begin -->
     <FooterSession/>
      <!-- Footer Section End -->

    <!-- Js Plugins -->
</template>
<script setup>
import HeaderSession from './HeaderSession.vue'
import FooterSession from './FooterSession.vue'
import Preloader from './Preloader.vue'
import { ref, onMounted, watch } from 'vue'
import { preloaderFunc } from '../assets/js/main';
const email = ref('');
const username = ref('');
const password = ref('');
const errorEmailMsg = ref('');
const errorPasswordMsg = ref('');
const errorUsernameMsg = ref('');
const emailCheck = ref(false);
const passwordCheck = ref(false);
const usernameCheck = ref(false);
const isAccept = ref(false);
watch(email, (newVal) => {
    if (!validateEmail(newVal)) {
        errorEmailMsg.value = 'Email không hợp lệ';
        emailCheck.value = false;
    } else {
        errorEmailMsg.value = '';
        emailCheck.value = true;
    }
    isAccept.value = emailCheck.value && passwordCheck.value && usernameCheck.value;
});
watch(password, (newVal) => {
    if (!validatePassword(password.value)) {
        errorPasswordMsg.value = 'Mật khẩu có từ 8-16 ký tự: Chữ hoa, chữ thường, số và ký tự đặc biệt';
        passwordCheck.value = false;
    } else {
        errorPasswordMsg.value = '';
        passwordCheck.value = true;
    }
    isAccept.value = emailCheck.value && passwordCheck.value && usernameCheck.value;
});
watch(username, (newVal) => {
    if (!validateUsername(username.value)) {
        errorUsernameMsg.value = 'Tên người dùng không được để trống';
        usernameCheck.value = false;
    } else {
        errorUsernameMsg.value = '';
        usernameCheck.value = true;
    }
    isAccept.value = emailCheck.value && passwordCheck.value && usernameCheck.value;
});

const register = async () => {
    let registerInfo = {
        email: email.value,
        username: username.value,
        password: password.value,
    };
    try {
        const response = await fetch('http://localhost:8080/user/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(registerInfo),
        });
        if (!response.ok) {
            const error = await response.json();
            errorEmailMsg.value = error.message;
            return;
        }
        const data = await response.json();

    } catch (error) {
        console.error('Error:', error);
    }
}

function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
}


function validatePassword(password) {
    if (password.length < 8 || password.length > 16) {
        return false;
    }

    const hasUpperCase = /[A-Z]/.test(password);
    const hasLowerCase = /[a-z]/.test(password);
    const hasNumber = /\d/.test(password);
    const hasSpecialChar = /[!@#$%^&*(),.?":{}|<>]/.test(password);

    return hasUpperCase && hasLowerCase && hasNumber && hasSpecialChar;
}

function validateUsername(username) {
    return username.trim() !== '';
}

onMounted(() => {
    preloaderFunc();
})
</script>
<style scoped>
.text-error {
    color: red;
    font-size: 12px;
}

.disabled-btn {
    background-color: #ccc;
    cursor: not-allowed;
}
</style>