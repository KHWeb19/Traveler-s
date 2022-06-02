import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

<<<<<<< HEAD
//member
import SignUp from '@/views/member/SignUp.vue'
import LogIn from '@/views/member/LogIn.vue'
=======

>>>>>>> 67e3d113041979b3459d984721929f3756e001a6

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  //member
  {
    path: '/signup',
    name: 'SignUp',
    component: SignUp
  },
  {
    path: '/login',
    name: 'LogIn',
    component: LogIn
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
