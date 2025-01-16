<template lang="">
    <section class="hero">
    <div class="container">
      <div class="hero__slider owl-carousel">
        <div class="hero__items set-bg" data-setbg="../assets/img/hero/hero-1.jpg">
          <div class="row">
            <div class="col-lg-6">
              <div class="hero__text">
                <div class="label">Adventure</div>
                <h2>Fate / Stay Night: Unlimited Blade Works</h2>
                <p>After 30 days of travel across the world...</p>
                <a href="#"><span>Watch Now</span> <i class="fa fa-angle-right"></i></a>
              </div>
            </div>
          </div>
        </div>
        <div class="hero__items set-bg" data-setbg="../assets/img/hero/hero-1.jpg">
          <div class="row">
            <div class="col-lg-6">
              <div class="hero__text">
                <div class="label">Adventure</div>
                <h2>Fate / Stay Night: Unlimited Blade Works</h2>
                <p>After 30 days of travel across the world...</p>
                <a href="#"><span>Watch Now</span> <i class="fa fa-angle-right"></i></a>
              </div>
            </div>
          </div>
        </div>
        <div class="hero__items set-bg" data-setbg="../assets/img/hero/hero-1.jpg">
          <div class="row">
            <div class="col-lg-6">
              <div class="hero__text">
                <div class="label">Adventure</div>
                <h2>Fate / Stay Night: Unlimited Blade Works</h2>
                <p>After 30 days of travel across the world...</p>
                <a href="#"><span>Watch Now</span> <i class="fa fa-angle-right"></i></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<script setup>
import { ref, onMounted } from 'vue';
import { preloaderFunc, backGroundSetFunc, initNavigation, initHeroSlider, initSearchModel } from '../assets/js/main.js';
onMounted(() => {
  initHeroSlider();
});
// const topMovies = ref(['../assets/img/hero/hero-1.jpg', '../assets/img/hero/hero-2.jpg', '../assets/img/hero/hero-3.jpg']);
// const heroSlide = ref(null);
// mainJSQuery.heroSliderFunc();

</script>