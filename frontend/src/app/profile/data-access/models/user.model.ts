export interface CurrentUser {
  id: number
  name: string
  username: string
  email: string
  password: string
  role: string
  enabled: boolean
  authorities: {authority: string}[]
  accountNonExpired: boolean
  accountNonLocked: boolean
  credentialsNonExpired: boolean
}

export interface User {
  id: number
  name: string
  username: string
  email: string
  password: string
  role: string
  enabled: boolean
  authorities: {authority: string}[]
  accountNonExpired: boolean
  accountNonLocked: boolean
  credentialsNonExpired: boolean
}
