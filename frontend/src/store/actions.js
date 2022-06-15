import {
    FETCH_HOTEL_LIST,
    FETCH_HOTEL,
    IS_LOGGEDIN,
    NOT_LOGGEDIN
} from './mutation-types'

import axios from 'axios'
import router from '@/router'

export default {
    fetchHotelList ({ commit }) {
        return axios.get('http://localhost:7777/hotel/list')
                .then((res) => {
                    commit(FETCH_HOTEL_LIST, res.data)
                })
    },
    fetchHotel ({ commit }, hotelNo) {
        return axios.get(`http://localhost:7777/hotel/${hotelNo}`)
                .then((res) => {
                    commit(FETCH_HOTEL, res.data)
                })
    },
    attemptLogin({commit, state}, payload){
        axios.post("http://localhost:7777/login", payload, {withCredentials: true})
        .then((res) => {
            localStorage.setItem("access_token", res.data.accessToken)
            commit(IS_LOGGEDIN)
            console.log(state.isLoggedIn)
            router.push("/")
        })
        .catch(() => alert("Invalid username or password"))
    },
    attemptLogout({commit}){
        axios.post('http://localhost:7777/logout', {}, {withCredentials: true})
        .then(() => {
            localStorage.removeItem("access_token")
            commit(NOT_LOGGEDIN)
            router.push("/")
        })
        .catch(() => alert("로그인 실패"))
    },
    validate_login({commit}){
        localStorage.getItem('access_token') ? commit(IS_LOGGEDIN) : commit(NOT_LOGGEDIN)
    }
}