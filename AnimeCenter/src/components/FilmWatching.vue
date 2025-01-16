<template lang="">
    <!-- Page Preloder -->
     <Preloader/>
    <!-- Header Section Begin -->
     <HeaderSession/>
    <!-- Header End -->

    

    <!-- Anime Section Begin -->
     <template v-if="dataLoadDone">
    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                        <a href="./categories.html">Categories</a>
                        <a href="./categories.html">
                            <template v-for="(genre,index) in film.genres" :key="index">
                                {{genre.name}}
                                <template v-if="index < film.genres.length - 1">
                                    ,
                                </template>
</template>
</a>
<span>{{film.title}}</span>
</div>
</div>
</div>
</div>
</div>

<!-- Breadcrumb End -->

<section class="anime-details spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="anime__video__player">
                    <video @timeupdate="videoCheck" id="player" playsinline controls :data-poster="film.image">
                        <source :src="`http://localhost:8080/api/videos/stream/${film.id}`" type="video/mp4">
                        </source>
                        <!-- <source :src="film.filmLink" type="video/mp4" ></source> -->

                        <!-- Captions are optional -->
                        <track kind="captions" label="English captions" src="#" srclang="en" default />
                    </video>
                </div>
                <ShowLoader :items="sameGenre" :title="`Phim cùng thể loại`" />

            </div>
        </div>
        <div class="row">
            <div class="col-lg-8">
                <div class="anime__details__review">
                    <div class="section-title">
                        <h5>Reviews</h5>
                    </div>
                    <div v-for="(comment,index) in film.comments" :key="index" class="anime__review__item">
                        <div class="anime__review__item__pic">
                            <img src="/src/assets/img/anime/review-1.jpg" alt="">
                        </div>
                        <div class="anime__review__item__text">
                            <h6>{{comment.user.username}} - <span>{{timeDifference(comment.createdAt)}}</span></h6>
                            <p>{{comment.text}}</p>
                        </div>
                    </div>

                </div>
                <div class="anime__details__form">
                    <div class="section-title">
                        <h5>Your Comment</h5>
                    </div>
                    <form @submit.prevent="commentAction" action="#">
                        <textarea placeholder="Your Comment" v-model="commentContent"></textarea>
                        <button type="button" v-on:click="commentAction()"><i class="fa fa-location-arrow"></i>
                            Review</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
</template>
<!-- Anime Section End -->

<!-- Footer Section Begin -->
<FooterSession />
<!-- Footer Section End -->

<!-- Search model Begin -->
<!-- Search model end -->

<!-- Js Plugins -->

</template>
<script setup>
import { ref, onMounted, nextTick } from 'vue';
import HeaderSession from './HeaderSession.vue';
import Preloader from './Preloader.vue';
import FooterSession from './FooterSession.vue';
import ShowLoader from './ShowLoader.vue';
import { preloaderFunc, backGroundSetFunc, initNavigation, initHeroSlider, initSearchModel, filterLoader } from '../assets/js/main.js';
import { useRoute } from "vue-router";
const player = ref(null);
const film = ref(undefined);
const sameGenre = ref(undefined);
const dataLoadDone = ref(false);
const route = useRoute();
const id = ref(route.params.id || 1);
const currentToken = ref(JSON.parse(window.localStorage.getItem('token')));
const commentContent = ref('');
const currentTime = ref(0);
const totalTime = ref(0);
const isStopCount = ref(false);
const loadData = async () => {
    try {
        const response = await fetch(`http://localhost:8080/theater/film/one/${id.value}`);
        if (!response.ok) {
            throw new Error('Not Found');
        }
        const data = await response.json();
        film.value = data.data;
    } catch (error) {
        console.log(error);
    }
}
const commentAction = async () => {
    if (!validateComment(commentContent.value)) {
        window.alert("Nội dung không được để trống");
        return;
    }

    try {
        const commentObject =
        {
            authenEntity: currentToken.value,
            movieId: id.value,
            content: commentContent.value
        };
        const response = await fetch(`http://localhost:8080/theater/film/comment/post`,
            {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(commentObject)
            }
        );
        if (!response.ok) {
            const data = await response.json();
            let isLoginAgain = window.confirm(data.message);
            if (isLoginAgain) {
                window.location.href = '/login';
            }
        }
        commentContent.value = '';

    } catch (error) {

    }

}
const commentReloads = async () => {
    try {
        const response = await fetch(`http://localhost:8080/theater/film/comment/get/${id.value}`);
        if (!response.ok) {
            throw new Error('Not Found');
        }
        const data = await response.json();
        film.value.comments = await data.data;

    } catch (error) {
        console.log(error);
    }
}
const getSameGenre = async () => {
    dataLoadDone.value = false;
    const listNum = await film.value.genres.map(genre => genre.id);
    try {
        const response = await fetch(`http://localhost:8080/theater/film/by-genres/3`,
            {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(listNum)
            }
        );
        if (!response.ok) {
            throw new Error('Not Found');
        }
        const data = await response.json();
        sameGenre.value = data.data;
    } catch (error) {
        console.log(error);
    }
    dataLoadDone.value = true;
}
const videoCheck = async (event) => {
    if (isStopCount.value) return;
    const video = event.target;
    if (video.currentTime - currentTime.value <= 0.3 && currentTime.value < video.currentTime) {
        totalTime.value += (video.currentTime - currentTime.value);
    }
    if (totalTime.value >= 30) {
        await plusViewMovie();
        isStopCount.value = true;
        return;
    }
    currentTime.value = video.currentTime;
}
const plusViewMovie = async () => {
    try {
        const response = await fetch(`http://localhost:8080/theater/film/watching/${id.value}`);
        if(!response.ok){
            throw new Error('Not Found');
        }
        const data = await response.json();
        film.value.totalViews += 1;
        console.log(film.value.totalViews);
    } catch (error) {
        console.log(error);
    }
}
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

function validateComment(comment) {
    console.log(comment);
    return comment.trim() !== '';
}
onMounted(async () => {
    preloaderFunc();
    backGroundSetFunc();
    initSearchModel();
    await loadData();
    await getSameGenre();
    player.value = new Plyr('#player', {
        controls: ['play-large',
            'play',
            'progress',
            'mute', 'volume', 'captions', 'settings', 'pip', 'airplay',
            'fullscreen'],
        seekTime: 25,
    });
});
setInterval(commentReloads, 2000);
</script>
<style lang="">

</style>
<style src="../assets/css/bootstrap.min.css"></style>
<style src="../assets/css/font-awesome.min.css"></style>
<style src="../assets/css/elegant-icons.css"></style>
<style src="../assets/css/plyr.css"></style>
<style src="../assets/css/nice-select.css"></style>
<style src="../assets/css/owl.carousel.min.css"></style>
<style src="../assets/css/slicknav.min.css"></style>
<style src="../assets/css/style.css"></style>