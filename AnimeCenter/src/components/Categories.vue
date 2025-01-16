<template lang="">
    <!-- Page Preloder -->
    <Preloader/>
    <!-- Header Section Begin -->
     <Header/>
    <!-- Header End -->

    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                        <a href="./categories.html">Categories</a>
                        <span>{{genre}}</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Product Section Begin -->
    <section class="product-page spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="product__page__content">
                        <ShowLoader v-if="animeData.length > 0" :items="animeData" :isMultiblePage="true" :sizeOfPage="6" :title="genre" />
                    </div>
                    
                </div>
    <SideBarLoader/>
</div>
</div>
</section>
<!-- Product Section End -->

<!-- Footer Section Begin -->
 <Footer/>
<!-- Footer Section End -->

  <!-- Search model Begin -->
<!-- Search model end -->

<!-- Js Plugins -->
</template>
<script setup>
import Header from "./HeaderSession.vue";
import Footer from "./FooterSession.vue";
import ShowLoader from "./ShowLoader.vue";
import Preloader from "./Preloader.vue";
import SideBarLoader from "./SideBarLoader.vue";
import { ref, onMounted, watch } from 'vue';
import { preloaderFunc, backGroundSetFunc, initNavigation, initHeroSlider, initSearchModel, filterLoader } from '../assets/js/main.js';
import { useRoute } from "vue-router";
const route = useRoute();
const genre = ref(route.params.genre || 'Romance');
const animeData = ref([]);
// Fetch dữ liệu từ back end
const fetchAnimeData = async () => {
  try {
    const response = await fetch(`http://localhost:8080/theater/genre/one/${genre.value}`);
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    const data = await response.json();
    animeData.value = data.data.movies;
    console.log('Fetched anime data:', animeData.value); // Kiểm tra dữ liệu trả về
  } catch (error) {
    console.error('There has been a problem with your fetch operation:', error);
  }
};
// watch(() => route.params.genre, async (newGenre) => {
//   genre.value = newGenre || 'Romance';
//   console.log('Genre changed:', genre.value);
//   await fetchAnimeData();
// });
onMounted(async () => {
    backGroundSetFunc();
    filterLoader();
    initSearchModel();
    await fetchAnimeData();
    
});

</script>
<style lang="">

</style>