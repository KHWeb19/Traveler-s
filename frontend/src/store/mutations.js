import {
    FETCH_HOTEL_LIST,
    FETCH_HOTEL,

    FETCH_BM_HOTEL_LIST,
    FETCH_BMHOTEL,

    GET_HOTEL_TYPE,

    FETCH_BMROOM_LIST
} from './mutation-types'

export default {
    IS_LOGGEDIN(state){
        state.isLoggedIn = true
    },
    NOT_LOGGEDIN(state){
        state.isLoggedIn = false
    },
    SET_USER(state, user){
        state.user = user
    },
    [FETCH_HOTEL_LIST] (state, hotels) {
        state.hotels = hotels
    },
    [FETCH_HOTEL] (state, hotel) {
        state.hotel = hotel
    },
    [GET_HOTEL_TYPE] (state, hotelType){
        state.hotelType = hotelType
    },
    [FETCH_BM_HOTEL_LIST] (state, bmHotels) {
        state.bmHotels = bmHotels
    },
    [FETCH_BMHOTEL] (state, bmhotel) {
        state.hotel = bmhotel
    },
    [FETCH_BMROOM_LIST] (state,bmRooms) {
        state.rooms = bmRooms
    }
}