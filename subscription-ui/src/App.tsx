import SubscriptionForm from "./components/SubscriptionForm";
import { Provider } from 'react-redux'
import { combineReducers } from 'redux'
import { reducer as reduxFormReducer } from 'redux-form'
import { configureStore } from "@reduxjs/toolkit";
import React from 'react';

const reducer = combineReducers({
  form: reduxFormReducer 
})

export const store = configureStore({
  reducer: reducer
});

function App() {
  return (
    <Provider store={store}>
      <SubscriptionForm onSubmit={submit}/>
    </Provider>
  );
}

function submit(values: any) {
  window.alert(`Form values are stored in redux store under "form.subscriptionForm.values".\n\n Submitted Values:\n\n${JSON.stringify(values, null, 2)}`)
}
export default App;
