<template>
  <!-- Page Preloder -->
  <!-- <div id="preloader">
    <div class="loader"></div>
  </div> -->

  <Preloader />
  <!-- <div id="preloader">
    <div class="loader"></div>
  </div> -->
  <!-- Header Section Begin -->
  <HeaderSession />
  <!-- Header End -->

  <!-- Hero Section Begin -->
  <HeroSession />
  <!-- Hero Section End -->
  <template v-if="dataLoadDone">
    <!-- Product Section Begin -->
    <section class="product spad">
      <div class="container">
        <div class="row">
          <div class="col-lg-8">
            <!--Trending Now Begin-->
            <ShowLoader :title="'Trending Now'" :items="part1" />
            <!--Trending Now End-->
            <!--Popular Product Begin-->
            <ShowLoader :title="'Popular Shows'" :items="part2" />
            <!--Popular Product End-->
            <!--Recent Product Begin-->
            <ShowLoader :title="'Recent Added Shows'" :items="part3" />
            <!--Recent Product End-->
          </div>
          <!-- Sidebar Begin -->
          <SideBarLoader />
          <!-- Sidebar End -->
        </div>
      </div>
    </section>
  </template>
  <!-- Product Section End -->

  <!-- Footer Section Begin -->
  <FooterSession />
  <!-- Footer Section End -->

  <!-- Search model Begin -->
  <!-- <div class="search-model">
    <div class="h-100 d-flex align-items-center justify-content-center">
      <div class="search-close-switch"><i class="icon_close"></i></div>
      <form class="search-model-form">
        <input type="text" id="search-input" placeholder="Search here....." />
      </form>
    </div>
  </div> -->
  <!-- Search model end -->

  <!-- Js Plugins -->
</template>
<script setup>
import HeaderSession from "./HeaderSession.vue";
import HeroSession from "./HeroSession.vue";
import Preloader from "./Preloader.vue";
import { onMounted } from 'vue';
import { preloaderFunc, backGroundSetFunc, initNavigation, initHeroSlider, initSearchModel, filterLoader } from '../assets/js/main.js';
import FooterSession from "./FooterSession.vue";
import ShowLoader from "./ShowLoader.vue";
import { ref } from 'vue';
import SideBarLoader from "./SideBarLoader.vue";

// Chia data thành 4 phần, mỗi phần có 6 object
const part1 = ref([]);
const part2 = ref([]);
const part3 = ref([]);
const dataLoadDone = ref(false);

const fetchData = async () => {
  dataLoadDone.value = false;
  try {
    const response1 = await fetch(`http://localhost:8080/theater/film/trending/6`);
    const response2 = await fetch(`http://localhost:8080/theater/film/popular/6`);
    const response3 = await fetch(`http://localhost:8080/theater/film/new/6`);
    if(response1.ok){
      const data1 = await response1.json();
      part1.value = await data1.data;
    }
    if(response2.ok){
      const data2 = await response2.json();
      part2.value = await data2.data;
    }
    if(response3.ok){
      const data3 = await response3.json();
      part3.value = await data3.data;
    }
  } catch (error) {
    console.log(error)
  }
  dataLoadDone.value = true;
}



onMounted(async () => {
  await fetchData();
  filterLoader();
  backGroundSetFunc();
  initSearchModel();
});
</script>
<style src="../assets/css/bootstrap.min.css"></style>
<style src="../assets/css/font-awesome.min.css"></style>
<style src="../assets/css/elegant-icons.css"></style>
<style src="../assets/css/plyr.css"></style>
<style src="../assets/css/nice-select.css"></style>
<style src="../assets/css/owl.carousel.min.css"></style>
<style src="../assets/css/slicknav.min.css"></style>
<style src="../assets/css/style.css"></style>
