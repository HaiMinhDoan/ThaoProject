import { createRouter, createWebHistory } from 'vue-router'
import HomePage from '../components/HomePage.vue'
import Categories from '@/components/Categories.vue'
import FilmDetail from '@/components/FilmDetail.vue'
import Register from '@/components/Register.vue'
import Login from '@/components/Login.vue'
import FilmWatching from '@/components/FilmWatching.vue'
import SearchPage from '@/components/SearchPage.vue'
import AdminDashboard from '@/components/AdminDashboard.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'homepage',
      component: HomePage,
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue'),
    },
    {
      path: '/categories/:genre?',
      name: 'categories',
      component: Categories,
    },
    {
      path: '/film-details/:id?',
      name: 'film-details',
      component: FilmDetail,
    },
    {
      path: '/register',
      name: 'register',
      component: Register,
    },
    {
      path: '/login',
      name: 'login',
      component: Login,
    },
    {
      path: '/film-watching/:id?',
      name: 'film-watching',
      component: FilmWatching,
    },
    {
      path: '/search-page',
      name: 'search-page',
      component: SearchPage,
    },
    {
      path: '/admin-dashboard',
      name: 'admin-dashboard',
      component: AdminDashboard,
    },
  ],
})

export default router
