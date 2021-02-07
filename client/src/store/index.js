import { createStore, applyMiddleware, combineReducers } from 'redux';
import thunk from 'redux-thunk';
import logger from 'redux-logger';
import userReducer from './reducers/UserReducer';

export const middlewares = [thunk, logger];

export const createStoreWithMiddlewares = applyMiddleware(...middlewares)(
  createStore
);

export const rootReducer = combineReducers({
  user: userReducer,
});

const store = createStoreWithMiddlewares(rootReducer);

export default store;
