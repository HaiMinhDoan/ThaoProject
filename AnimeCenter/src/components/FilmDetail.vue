<template lang="">

    <!-- Page Preloder -->
    <Preloader />

    <!-- Header Section Begin -->
    <HeaderSession />
    <!-- Header End -->
     
    <template v-if="dataLoadDone">
        <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                        <a href="./categories.html">Categories</a>
                        <span>Romance</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->
    <!-- Anime Section Begin -->
    <section class="anime-details spad">
        <div class="container">
            <div class="anime__details__content">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="anime__details__pic set-bg" :style="{backgroundImage: 'url(' + animeDetails.image + ')'}">
                            <div class="comment"><i class="fa fa-comments"></i> {{animeDetails.comments.length}}</div>
                            <div class="view"><i class="fa fa-eye"></i>  {{animeDetails.totalViews}}</div>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="anime__details__text">
                            <div class="anime__details__title">
                                <h3>{{animeDetails.title}}</h3>
                                <span>{{animeDetails.japaneseTitle}}</span>
                            </div>
                            <div class="anime__details__rating">
                                <div class="rating">
                                    <a href="#"><i :class="{'fa':true,'fa-star':(animeDetails.ratings.length-0 > 0.5),'fa-star-half-o':(animeDetails.ratings.length-0 == 0.5)}" ></i></a>
                                    <a href="#"><i :class="{'fa':true,'fa-star':(animeDetails.ratings.length-1 > 0.5),'fa-star-half-o':(animeDetails.ratings.length-1 == 0.5)}" ></i></a>
                                    <a href="#"><i :class="{'fa':true,'fa-star':(animeDetails.ratings.length-2 > 0.5),'fa-star-half-o':(animeDetails.ratings.length-2 == 0.5)}" ></i></a>
                                    <a href="#"><i :class="{'fa':true,'fa-star':(animeDetails.ratings.length-3 > 0.5),'fa-star-half-o':(animeDetails.ratings.length-3 == 0.5)}" ></i></a>
                                    <a href="#"><i :class="{'fa':true,'fa-star':(animeDetails.ratings.length-4 > 0.5),'fa-star-half-o':(animeDetails.ratings.length-4 == 0.5)}" ></i></a>
                                </div>
                                <span>{{animeDetails.ratings.length}} Votes</span>
                            </div>
                            <p>{{animeDetails.description}}</p>
                            <div class="anime__details__widget">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6">
                                        <ul>
                                            <li><span>Trạng thái:</span>{{animeDetails.status}}</li>
                                            <li><span>Thể loại:</span>
                                                <template v-for="(genre,index) in animeDetails.genres">
                                                    {{genre.name}}<template v-if="index < animeDetails.genres.length - 1">, </template>

</template>
</li>
<li><span>Lượt xem:</span> {{animeDetails.totalViews}}</li>
<li><span>Chất lượng:</span> {{animeDetails.quality}}</li>
<li><span>Thời lượng:</span> {{animeDetails.duration}}</li>
</ul>
</div>
<div class="col-lg-6 col-md-6">
    <ul>

        <li><span>Lượt đánh giá:</span> {{animeDetails.ratings.length}}</li>
    </ul>
</div>
</div>
</div>
<div class="anime__details__btn">
    <a href="#" class="follow-btn"><i class="fa fa-heart-o"></i> Follow</a>
    <router-link :to="`../film-watching/${animeDetails.id}`" class="watch-btn"><span>Watch Now</span> <i
            class="fa fa-angle-right"></i></router-link>
</div>
</div>
</div>
</div>
</div>
<div class="row">
    <div class="col-lg-8 col-md-8">
        <div class="anime__details__review">
            <div class="section-title">
                <h5>Reviews</h5>
            </div>
            <!-- Anime Review Begin -->
            <div v-for="(review,index) in animeDetails.comments" :key="index" class="anime__review__item">
                <div class="anime__review__item__pic">
                    <img src="/src/assets/img/anime/review-1.jpg" alt="">
                </div>
                <div class="anime__review__item__text">
                    <h6>{{review.user.username}} - <span>{{timeDifference(review.createdAt)}}</span></h6>
                    <p>{{review.text}}</p>
                </div>
            </div>
        </div>
        <div class="anime__details__form">
            <div class="section-title">
                <h5>Your Comment</h5>
            </div>
            <form action="#">
                <textarea placeholder="Your Comment"></textarea>
                <button type="submit"><i class="fa fa-location-arrow"></i> Review</button>
            </form>
        </div>
    </div>
    <SideBarLoader :title1="'you might like...'" :isFilter="false" />
</div>
</div>
</section>

<!-- Anime Section End -->
</template>

<!-- Footer Section Begin -->
<FooterSession />
<!-- Footer Section End -->

<!-- Js Plugins -->
</template>
<script setup>
import { ref, onMounted } from 'vue';
import { preloaderFunc, backGroundSetFunc, initNavigation, initHeroSlider, initSearchModel, filterLoader } from '../assets/js/main.js';
import { defineProps } from 'vue';
import HeaderSession from "./HeaderSession.vue";
import FooterSession from "./FooterSession.vue";
import Preloader from "./Preloader.vue";
import SideBarLoader from "./SideBarLoader.vue";
import { useRoute } from "vue-router";
// import Cookies from 'js-cookie';
const route = useRoute();
const id = ref(route.params.id || 1);
const animeDetails = ref(undefined);
const dataLoadDone = ref(false);

const fetchFilmDetails = async () => {
    dataLoadDone.value = false;
    const response = await fetch(`http://localhost:8080/theater/film/one/${id.value}`);
    try {
        if (!response.ok) {
            throw new Error('Not Found');
        }
        const data = await response.json();
        animeDetails.value = data.data;

    } catch (error) {
        console.log(error);
    }
    dataLoadDone.value = true;
};
function timeDifference(datetime) {
  const now = new Date();
  const inputTime = new Date(datetime);
  const diffInMilliseconds = now - inputTime;
  
  const diffInSeconds = Math.floor(diffInMilliseconds / 1000);
  const diffInMinutes = Math.ceil(diffInMilliseconds / (1000 * 60));
  const diffInHours = Math.floor(diffInMilliseconds / (1000 * 60 * 60));
  const diffInDays = Math.floor(diffInMilliseconds / (1000 * 60 * 60 * 24));
  const diffInWeeks = Math.floor(diffInMilliseconds / (1000 * 60 * 60 * 24 * 7));
  const diffInMonths = Math.floor(diffInMilliseconds / (1000 * 60 * 60 * 24 * 30));
  const diffInYears = Math.floor(diffInMilliseconds / (1000 * 60 * 60 * 24 * 365));

  if (diffInSeconds < 60) {
    return `${diffInSeconds} giây trước`;
  } else if (diffInMinutes < 60) {
    return `${diffInMinutes} phút trước`;
  } else if (diffInHours < 24) {
    const minutesPart = diffInMinutes % 60;
    return `${diffInHours} giờ ${minutesPart} phút trước`;
  } else if (diffInDays < 7) {
    return `${diffInDays} ngày trước`;
  } else if (diffInWeeks < 4) {
    const daysPart = diffInDays % 7;
    return `${diffInWeeks} tuần ${daysPart} ngày trước`;
  } else if (diffInMonths < 12) {
    const weeksPart = diffInWeeks % 4;
    return `${diffInMonths} tháng ${weeksPart} tuần trước`;
  } else {
    return `${diffInYears} năm trước`;
  }
}
onMounted(async () => {
    backGroundSetFunc();
    initNavigation();
    initSearchModel();
    filterLoader();
    await fetchFilmDetails();

});
</script>
<style lang="">

</style>