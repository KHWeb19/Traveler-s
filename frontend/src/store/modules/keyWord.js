export default {
    state: {
        searchKeyword: null,
        hotelReadKeyword: null
    },
    getters: {
        GET_SEARCH_LIST: state => state.searchKeyword
    },
    mutations: {
        SET_SEARCH_KEYWORD: (state, searchKeyword) => {
            state.searchKeyword = searchKeyword
        },
        SET_HOTEL_READ_KEYWORD: (state, hotelReadKeyword ) => {
            state.hotelReadKeyword = hotelReadKeyword
        }
    },
    actions: {
        setSearchKeyword({ commit }, payload) {
            commit('SET_SEARCH_KEYWORD', payload)
        },
        setHotelReadKeyWord({ commit }, payload) {
            commit('SET_HOTEL_READ_KEYWORD', payload)
        },
    }
  }