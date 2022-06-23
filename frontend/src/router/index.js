import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

import store from '@/store'

import HotelReadPage from '@/views/hotelDetail/HotelReadPage.vue'

import BHotelModifyPage from '@/views/hotel/HotelModifyPage.vue'
import BHotelReadPage from '@/views/hotel/HotelReadPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/member/MemberLogin.vue')
  },
  {
    path: '/signup',
    name: 'SignUp',
    component: () => import('@/views/member/MemberSignUp.vue')
  },
  {
    path: '/oauth2/redirect',
    name: 'OAuth2Redirect',
    component: () => import('../views/member/OAuth2Redirect.vue')
  },
  {
    path: '/BHotelListPage',
    name: 'BHotelListPage',
    component: () => import('../views/hotel/HotelListPage.vue')
  },
  {
    path: '/BHotelRegisterPage',
    name: 'BHotelRegisterPage',
    component: () => import('../views/hotel/HotelRegisterPage.vue')
  },
  {
    path: '/BHotelReadPage/:hotelNo',
    name: 'BHotelReadPage',
    components: {
      default: BHotelReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/BHotelModifyPage/:hotelNo',
    name: 'BHotelModifyPage',
    components: {
      default: BHotelModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/mypage',
    name: 'MyPage',
    component: () => import('../views/mypage/MyPage.vue')
  },
  {
    path: '/roomRegister',
    name: 'RoomRegisterPage',
    component: () => import('../views/hotel/RoomRegisterPage.vue')
  },
  {
    path: '/hotelReadPage/:hotelNo',
    name: 'HotelReadPage',
    components: {
      default: HotelReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/search',
    name: 'SearchPage',
    component: () => import('../views/searchpage/SearchPage.vue')
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})


router.beforeEach(function(to,from,next){
  store.dispatch("validate_login")
  next()
})

export default router