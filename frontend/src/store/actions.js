import {
  FETCH_M_HOTEL_LIST,
  FETCH_M_HOTEL,
  FETCH_M_ROOM_LIST,
  FETCH_M_ROOM,
  IS_LOGGEDIN,
  NOT_LOGGEDIN,
  SET_USER,
  GET_HOTEL_TYPE,
  FETCH_BM_HOTEL_LIST,
  FETCH_BM_HOTEL,
  FETCH_BM_ROOM,
  FETCH_BM_ROOM_LIST,
  FETCH_WISH_LISTS,
  FETCH_BOOKING_LISTS,
  FETCH_SEARCH_LISTS,
  FETCH_CEOBOOKING_LISTS,

} from "./mutation-types";

import axios from "axios";
import router from "@/router";

export default {
  fetchMHotelList({ commit }) {
    return axios.get("http://localhost:7777/hotel/mainList").then((res) => {
      commit(FETCH_M_HOTEL_LIST, res.data);
    });
  },
  fetchMHotel({ commit }, hotelNo) {
    return axios
      .get(`http://localhost:7777/hotel/mRead/${hotelNo}`)
      .then((res) => {
        commit(FETCH_M_HOTEL, res.data);
      });
  },
  fetchMRoomList({ commit }, payload) {
    return axios.post("http://localhost:7777/room/mem/list", payload).then((res) => {
      commit(FETCH_M_ROOM_LIST, res.data);
    });
  },
  fetchMRoom({ commit }, roomNo) {
    return axios.get(`http://localhost:7777/room/mem/${roomNo}`).then((res) => {
      commit(FETCH_M_ROOM, res.data);
    });
  },
  fetchBmHotelList({ commit }) {
    return axios.get("http://localhost:7777/hotel/bm/list").then((res) => {
      commit(FETCH_BM_HOTEL_LIST, res.data);
    });
  },
  fetchBmHotel({ commit }, hotelNo) {
    return axios
      .get(`http://localhost:7777/hotel/bm/${hotelNo}`)
      .then((res) => {
        commit(FETCH_BM_HOTEL, res.data);
      });
  },
  attemptLogin({dispatch, commit}, payload) {
    axios
      .post("http://localhost:7777/login", payload, { withCredentials: true })
      .then((res) => {
        localStorage.setItem("access_token", res.data.accessToken);
        commit(IS_LOGGEDIN);
        dispatch('setUser');
        console.log('해줌')
        router.push("/");
      })
      .catch(() => alert("Invalid username or password"));
  },
  attemptLogout({ commit }) {
    axios
      .post("http://localhost:7777/logout", {}, { withCredentials: true })
      .then(() => {
        localStorage.removeItem("access_token");
        commit(NOT_LOGGEDIN);
        router.push("/");
      })
      .catch(() => alert("로그인 실패"));
  },
  validate_login({ commit }) {
    localStorage.getItem("access_token")
      ? commit(IS_LOGGEDIN)
      : commit(NOT_LOGGEDIN);
  },
  setUser({ commit }) {
    axios
      .get("http://localhost:7777/getUser")
      .then((res) => {
        commit(SET_USER, res.data);
      })
      .catch(() => {
        router.push({ path: "/login" });
        alert("내 정보를 읽어오는데 실패했습니다");
      });
  },
  getHotelType({ commit }) {
    axios.get("http://localhost:7777/room/getHotelType").then((res) => {
      commit(GET_HOTEL_TYPE, res.data);
    });
  },
  fetchBmRoom({ commit }, roomNo) {
    return axios.get(`http://localhost:7777/room/bm/${roomNo}`).then((res) => {
      commit(FETCH_BM_ROOM, res.data);
    });
  },
  fetchBmRoomList({ commit }, hotelNo) {
    axios
      .post("http://localhost:7777/room/bm/list", { hotelNo })
      .then((res) => {
        commit(FETCH_BM_ROOM_LIST, res.data);
      });
  },
  fetchWishLists({ commit }) {
    axios.get("http://localhost:7777/wish/HotelList").then((res) => {
      commit(FETCH_WISH_LISTS, res.data);
    });
  },
  fetchBookingLists({ commit }) {
    axios
      .get("http://localhost:7777/reserve/user/listAllReservations")
      .then((res) => {
        commit(FETCH_BOOKING_LISTS, res.data);
      });
  },
  fetchCeoBookingLists({ commit }) {
    axios
      .get("http://localhost:7777/reserve/ceo/listAllReservations")
      .then((res) => {
        commit(FETCH_CEOBOOKING_LISTS, res.data);
      });
  },
  fetchSearchLists({ commit }, payload){
    axios.post('http://localhost:7777/search/commonSearch', payload)
                    .then((res) => {
                     commit(FETCH_SEARCH_LISTS, res.data)
                })
   }
};
