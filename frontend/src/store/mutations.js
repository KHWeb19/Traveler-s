import {
  FETCH_M_HOTEL_LIST,
  FETCH_M_HOTEL,
  FETCH_M_ROOM_LIST,
  FETCH_M_ROOM,
  FETCH_BM_HOTEL_LIST,
  FETCH_BM_HOTEL,
  GET_HOTEL_TYPE,
  FETCH_BM_ROOM,
  FETCH_BM_ROOM_LIST,
  FETCH_WISH_LISTS,
  FETCH_BOOKING_LISTS,
  FETCH_SEARCH_LISTS
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
  [FETCH_M_ROOM_LIST](state, mRooms) {
    state.mRooms = mRooms;
  },
  [FETCH_M_ROOM](state, mRoom) {
    state.mRoom = mRoom;
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
  [FETCH_BM_ROOM_LIST](state, bmRoomList) {
    state.bmRoomList = bmRoomList;
  },
  [FETCH_WISH_LISTS](state, wishLists) {
    state.wishLists = wishLists;
  },
  [FETCH_BOOKING_LISTS](state, bookingLists) {
    state.bookingLists = bookingLists;
  },
  [FETCH_SEARCH_LISTS](state, searchList){
    state.searchList = searchList
  }
};
