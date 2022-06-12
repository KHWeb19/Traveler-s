export const BASE_URL = "http://localhost:7777"

export const REDIRECT_URL = "http://localhost:8080/oauth2/redirect"

export const GOOGLE_URL = BASE_URL + "/oauth2/authorize/google?redirect_uri=" + REDIRECT_URL

export const NAVER_URL = BASE_URL + "/oauth2/authorize/naver?redirect_uri=" + REDIRECT_URL
