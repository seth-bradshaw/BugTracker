import { login, register } from "../../utils/otherAxiosCalls";
import axiosWithAuth from "../../utils/axiosWithAuth";

export const types = {
	LOGIN_START: 'LOGIN_START',
	LOGIN_SUCCESS: 'LOGIN_SUCCESS',
	LOGIN_ERROR: 'LOGIN_ERROR',
	LOGIN_RESOLVE: 'LOGIN_RESOLVE',
	REGISTER_START: 'REGISTER_START',
	REGISTER_SUCCESS: 'REGISTER_SUCCESS',
	REGISTER_ERROR: 'REGISTER_ERROR',
	REGISTER_RESOLVE: 'REGISTER_RESOLVE',
	GET_USER_INFO_START: 'GET_USER_INFO_START',
	GET_USER_INFO_SUCCESS: 'GET_USER_INFO_SUCCESS',
	GET_USER_INFO_FAIL: 'GET_USER_INFO_FAIL',
	GET_USER_INFO_RESOLVE: 'GET_USER_INFO_RESOLVE',
};

export const actions = {
	loginThunk: (creds) => (dispatch) => {
		dispatch({ type: types.LOGIN_START });
		login(creds)
			.then((res) => {
				localStorage.setItem('token', )
				dispatch({ type: types.LOGIN_SUCCESS, payload: true });
			})
			.catch((err) => {
				dispatch({ type: types.LOGIN_ERROR, payload: err.message });
			})
			.finally(() => {
				dispatch({ type: types.LOGIN_RESOLVE });
			})
	},

	registerThunk: (newUser) => (dispatch) => {
		dispatch({ type: types.REGISTER_START });
		register(newUser)
			.then((res) => {
				dispatch({ type: types.REGISTER_SUCCESS, payload: true });
			})
			.catch((err) => {
				dispatch({ type: types.REGISTER_ERROR, action: err.message });
			})
			.finally(() => {
				dispatch({ type: types.REGISTER_RESOLVE });
			});
	},

	getUserInfoThunk: () => (dispatch) => {
		dispatch({ type: types.GET_USER_INFO_START });
		axiosWithAuth()
			.get('/getuserinfo')
	}
};

export const initialState = {
	user: null,
	role: null,
	status: 'idle',
};

const userReducer = (state = initialState, action) => {
	switch (action.type) {
		default:
			return state;
	};
};

export default userReducer;