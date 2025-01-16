<template lang="">
    <header class="header">
        <div class="container">
          <div class="row">
            <div class="col-lg-2">
              <div class="header__logo">
                <a href="./index.html">
                  <img src="../assets/img/logo.png" alt="" />
                </a>
              </div>
            </div>
            <div class="col-lg-8">
              <div class="header__nav">
                <nav class="header__menu mobile-menu">
                  <ul>
                    <li><router-link to="/" active-class="active">HomePage</router-link></li>
                    <li>
                      <router-link to="/categories" active-class="active" :class="{'active':isInCatefories}">Categories <span class="arrow_carrot-down"></span></router-link>
                      <ul class="dropdown">
                        <!-- <li><a href="./anime-watching.html">Anime Watching</a></li>
                        <li><a href="./blog-details.html">Blog Details</a></li>
                        <li><a href="./signup.html">Sign Up</a></li>
                        <li><router-link to="/login">Login</router-link></li> -->
                        <li v-for="(genre_type,index) in genres" :key="index" :class="currentGenre===genre_type.name?'is_in_genre':''"><a :href="`/categories/${genre_type.name}`">{{genre_type.name}}</a></li>
                      </ul>
                    </li>
                    <li><a href="./blog.html">Our Blog</a></li>
                    <li><a href="#">Contacts</a></li>
                  </ul>
                </nav>
              </div>
            </div>
            <div class="col-lg-2">
              <div class="header__right">
                <a href="#" class="search-switch"><span class="icon_search"></span></a>
                <router-link v-if="!tokenCheck" to="/login"><span class="icon_key"></span></router-link>
                <a v-if="tokenCheck" @click="logout"><span class="icon_lock"></span></a>
                <img class="user_image" :src="tokenCheck?'https://www.freeiconspng.com/uploads/account-icon-23.png':'https://th.bing.com/th/id/OIP.U1FcsQimhEwceLMAYGs_TQHaHa?rs=1&pid=ImgDetMain'" alt="" />
              </div>
            </div>
          </div>
          <div id="mobile-menu-wrap"></div>
        </div>
      </header>
      <div class="search-model">
    <div class="h-100 d-flex align-items-center justify-content-center">
      <div class="search-close-switch"><i class="icon_close"></i></div>
      <form class="search-model-form" method="get" action="/search-page">
        <input type="text" id="search-input" name="search_text" placeholder="Search here....." />
      </form>
    </div>
  </div>
</template>
<script>
import { preloaderFunc, filterLoader } from '../assets/js/main.js';
import { onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';
export default {
  name: 'HeaderSession',
  setup() {
    const tokenCheck = ref(localStorage.getItem('token') ? JSON.parse(localStorage.getItem('token')) : null);
    const route = useRoute();
    const currentPath = ref(route.path);
    const currentGenre = ref(route.params.genre || '');
    const isInCatefories = ref(currentPath.value.includes('/categories'));
    function logout() {
      localStorage.removeItem('token');
      window.location.reload();
    }
    // fetch categories từ server
    const genres = ref([]);
    const fetchGenres = async () => {
      try {
        let response = await fetch('http://localhost:8080/theater/genre/all', {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json',
          }
        });
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        let data = await response.json();
        genres.value = data.data;
      } catch (error) {
        console.log(error);
      }
    };
    onMounted(async () => {
      await fetchGenres();
    });
    return { tokenCheck, logout, genres, fetchGenres,currentPath,currentGenre,isInCatefories };
  },
  beforeRouteEnter(to, from, next) {
    preloaderFunc();
    filterLoader();
    backGroundSetFunc();
    next();
  },
  beforeRouteUpdate(to, from, next) {
    preloaderFunc();
    filterLoader();
    backGroundSetFunc();
    next();
  },
  mounted() {

  }
};
</script>
<style scoped>
/* Add your styles here */
.active {
  font-weight: bold;
  color: #ffffff;
  width: 100%;
  height: 100%;
  background-color: #e53637;
  border-radius: 5px;
}
.is_in_genre{
  color: #ffffff;
  background-color: #e53637;
  border-radius: 11px;
}

.user_image {
  width: 38px;
  height: 38px;
  border-radius: 50%;
  overflow: hidden;
  object-fit: cover;
  display: inline-flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}
</style>