import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

import SignUp from '@/views/member/MemberSignUp.vue'
import OAuthRedirect from '@/views/member/OAuth2Redirect.vue'



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
    component: SignUp
  },
  {
    path: '/oauth2/redirect',
    name: 'OAuth2Redirect',
    component: OAuthRedirect
  },
  {
    path: '/hotel',
    name: 'HotelRegisterPage',
    component: () => import('../views/hotel/HotelRegisterPage.vue')
  },
  {
    path: '/reserve',
    name: 'reservDatail',
    component: () => import('../components/business/ReservDetail.vue')
  },
  

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
