import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

import store from '@/store'





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
    path: '/hotelRegister',
    name: 'HotelRegisterPage',
    component: () => import('../views/hotel/HotelRegisterPage.vue')
  }
  

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
