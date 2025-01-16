<template lang="">
            <div class="col-lg-4 col-md-6 col-sm-8">
          <div class="product__sidebar">
            <div class="product__sidebar__view">
              <div class="section-title">
                <h5>{{title1Crawler}}</h5>
              </div>
              <ul class="filter__controls" v-if="isFilter">
                <li class="active" data-filter="*">Day</li>
                <li data-filter=".week">Week</li>
                <li data-filter=".month">Month</li>
                <li data-filter=".years">Years</li>
              </ul>
              <div class="filter__gallery">
                <div v-for="(show, index) in items1Crawler" :key="index" 
                class="product__sidebar__view__item" 
                :class="{ 'mix':isFilter ,'day': show.isBestDay, 'week': show.isBestWeek, 'month': show.isBestMonth, 'years': show.isBestYear }" 
                :style="{backgroundImage: 'url(' + show.image + ')'}">
                  <div class="ep">{{ show.ep }}</div>
                  <div class="view"><i class="fa fa-eye"></i> {{ show.view }}</div>
                  <h5><a href="#">{{ show.title }}</a></h5>
                </div>
              </div>
            </div>
            <div class="product__sidebar__comment">
              <div class="section-title">
                <h5>{{title2Crawler}}</h5>
              </div>
              <div v-for="(film, index) in items2Crawler" :key="index" class="product__sidebar__comment__item">
                <div class="product__sidebar__comment__item__pic">
                  <img :src="film.image" alt=""/>
                </div>
                <div class="product__sidebar__comment__item__text">
                  <ul>
                    <li v-for="(genre, genreIndex) in film.genres" :key="genreIndex">
                      {{ genre }}
                    </li>
                  </ul>
                  <h5><a href="#">{{ film.title }}</a></h5>
                  <span><i class="fa fa-eye"></i> {{ film.view }} Viewes</span>
                </div>
              </div>
            </div>
          </div>
        </div>
</template>
<script setup>
import { ref, onMounted } from 'vue';
import { preloaderFunc, backGroundSetFunc, initNavigation, initHeroSlider, initSearchModel } from '../assets/js/main.js';
const topViewsTvShows = ref([
  {
    title: "Boruto: Naruto next generations",
    ep: "18 / ?",
    view: 9141,
    isBestWeek: false,
    isBestMonth: false,
    isBestYear: true,
    isBestDay: true,
    genres: ["Active", "Movie"],
    image: "../sr/assets/img/sidebar/tv-1.jpg"
  },
  {
    title: "The Seven Deadly Sins: Wrath of the Gods",
    ep: "18 / ?",
    view: 9141,
    isBestWeek: true,
    isBestMonth: true,
    isBestYear: false,
    isBestDay: false,
    genres: ["Active", "Movie"],
    image: "../src/assets/img/sidebar/tv-2.jpg"
  },
  {
    title: "Sword art online alicization war of underworld",
    ep: "18 / ?",
    view: 9141,
    isBestWeek: true,
    isBestMonth: false,
    isBestYear: true,
    isBestDay: false,
    genres: ["Active", "Movie"],
    image: "../src/assets/img/sidebar/tv-3.jpg"
  },
  {
    title: "Fate/stay night: Heaven's Feel I. presage flower",
    ep: "18 / ?",
    view: 9141,
    isBestWeek: false,
    isBestMonth: true,
    isBestYear: true,
    isBestDay: false,
    genres: ["Active", "Movie"],
    image: "../src/assets/img/sidebar/tv-4.jpg"
  },
  {
    title: "Fate stay night unlimited blade works",
    ep: "18 / ?",
    view: 9141,
    isBestWeek: false,
    isBestMonth: false,
    isBestYear: false,
    isBestDay: true,
    genres: ["Active", "Movie"],
    image: "../src/assets/img/sidebar/tv-5.jpg"
  }
]
);

const newFilms = ref(
  [
    {
      title: "The Seven Deadly Sins: Wrath of the Gods",
      view: 19141,
      genres: ["Active", "Movie"],
      image: "../src/assets/img/sidebar/comment-1.jpg"
    },
    {
      title: "Shirogane Tamashii hen Kouhan sen",
      view: 19141,
      genres: ["Active", "Movie"],
      image: "../src/assets/img/sidebar/comment-2.jpg"
    },
    {
      title: "Kizumonogatari III: Reiket su-hen",
      view: 19141,
      genres: ["Active", "Movie"],
      image: "../src/assets/img/sidebar/comment-3.jpg"
    },
    {
      title: "Monogatari Series: Second Season",
      view: 19141,
      genres: ["Active", "Movie"],
      image: "../src/assets/img/sidebar/comment-4.jpg"
    }
  ]
);
const props = defineProps({
  title1: {
    type: String,
    required: false,
    default: 'Top Views'
  },
  title2: {
    type: String,
    required: false,
    default: 'New Comment'
  },
  items1: {
    type: Array,
    required: false,
    default: () => []
  },
  items2: {
    type: Array,
    required: false,
    default: () => []
  },
  isFilter: {
    type: Boolean,
    required: false,
    default: true
  }
});
const title1Crawler = ref(props.title1);
const title2Crawler = ref(props.title2);
const items1Crawler = ref(props.items1);
const items2Crawler = ref(props.items2);
// kiểm tra các props có dữ liệu không nếu không thì gán giá trị mặc định
if (props.items1 && props.items1.length === 0) {
  items1Crawler.value =topViewsTvShows.value;
}
if (props.items2 && props.items2.length === 0) {
  items2Crawler.value = newFilms.value;
}
if (props.title1 && props.title1 === '') {
  title1Crawler.value = 'Top Views';
}
if (props.title2 && props.title2 === '') {
  title2Crawler.value = 'New Comment';
}
</script>