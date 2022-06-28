import {
  FETCH_M_HOTEL_LIST,
  FETCH_M_HOTEL,
  FETCH_BM_HOTEL_LIST,
  FETCH_BM_HOTEL,
  GET_HOTEL_TYPE,
  FETCH_BM_ROOM,
} from "./mutation-types";

export default {
  IS_LOGGEDIN(state) {
    state.isLoggedIn = true;
  },
  NOT_LOGGEDIN(state) {
    state.isLoggedIn = false;
  },
  SET_USER(state, user) {
    state.user = user;
  },
  [FETCH_M_HOTEL_LIST](state, mHotels) {
    state.mHotels = mHotels;
  },
  [FETCH_M_HOTEL](state, mHotel) {
    state.mHotel = mHotel;
  },
  [GET_HOTEL_TYPE](state, hotelType) {
    state.hotelType = hotelType;
  },
  [FETCH_BM_HOTEL_LIST](state, bmHotels) {
    state.bmHotels = bmHotels;
  },
  [FETCH_BM_HOTEL](state, bmHotel) {
    state.bmHotel = bmHotel;
  },
  [FETCH_BM_ROOM](state, bmRoom) {
    state.bmRoom = bmRoom;
  },
};
