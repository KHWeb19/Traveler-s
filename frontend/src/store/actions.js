import {
    FETCH_HOTEL_LIST,
    FETCH_HOTEL,
} from './mutation-types'

import axios from 'axios'

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
}