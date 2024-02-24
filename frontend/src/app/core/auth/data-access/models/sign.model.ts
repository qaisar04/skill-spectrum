export interface RegisterPayload {
  name: string
  username: string
  email: string
  inviteCode: string
  password: string
  confirmPassword: string
}

export interface LoginPayload {
  username: string
  password: string
}

export interface Token {
  token: string
}
