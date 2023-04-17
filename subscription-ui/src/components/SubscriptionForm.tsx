import { Field, reduxForm } from 'redux-form'
import React from 'react';

const required = (value: any) => (value || typeof value === 'number' ? undefined : 'Required')
const email = (value: string) => value && !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(value) ? 'Invalid email address' : undefined
const alphaNumeric = (value: string) => value && /[^a-zA-Z0-9 ]/i.test(value) ? 'Only alphanumeric characters' : undefined

const renderField = (props: {
  input: any,
  label:any,
  type: any,
  meta: { touched : any, error: any, warning: any }
}) => (
  <div>
    <label>{props.label}</label>
    <div>
      <input {...props.input} placeholder={props.label} type={props.type} />
      {props.meta.touched &&
        ((props.meta.error && <span>{props.meta.error}</span>) ||
          (props.meta.warning && <span>{props.meta.warning}</span>))}
    </div>
  </div>
)

const SubscriptionForm = (props: { handleSubmit: any; pristine: any; reset: any; submitting: any }) => {
  const { handleSubmit, pristine, reset, submitting } = props
  return (
    <form onSubmit={handleSubmit}>
      <Field
        name="name"
        type="text"
        component={renderField}
        label="Name"
        validate={required}
        warn={alphaNumeric}
      />
      <Field
        name="email"
        type="email"
        component={renderField}
        label="Email"
        validate={[required,email]}
      />
      <div>
        <label>User Type</label>
        <div>
          <Field 
          name="userType" 
          component="select">
            <option />
            <option value="Developer">Developer</option>
            <option value="Marketing">Marketing</option>
          </Field>
        </div>
      </div>
      <Field
        name="company"
        type="text"
        component={renderField}
        label="Company"
        validate={required}
        warn={alphaNumeric}
      />
      <div>
        <label>Application Type</label>
        <div>
          <Field 
          name="applicationType" 
          component="select">
            <option />
            <option value="Services">Services</option>
            <option value="WebApplication">WebApplication</option>
          </Field>
        </div>
      </div>
      <div>
        <button type="submit" disabled={submitting}>
          Submit
        </button>
        <button type="button" disabled={pristine || submitting} onClick={reset}>
          Clear Values
        </button>
      </div>
    </form>
  )
}

export default reduxForm({
  form: 'subscriptionForm' // a unique identifier for this form
})(SubscriptionForm)
