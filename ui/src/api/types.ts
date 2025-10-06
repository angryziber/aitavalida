export type Id<T extends Entity<T>> = string & {_of?: T}
export type Entity<T extends Entity<T>> = {id: Id<T>}

// class compass.CompassAnswers
export interface CompassAnswers {answers: Record<string, number>; area?: string; compassSlug: string; id: Id<CompassAnswers>; ipAddress?: string; lang: string; results: Record<string, number>; updatedAt: Instant; userAgent?: string}
// class users.Role
export enum Role {ADMIN = 'ADMIN', USER = 'USER'}
// class users.User
export interface User {firstName: string; id: Id<User>; lastName: string; role: Role}

// java.time.Instant
export type Instant = `${number}-${number}-${number}T${number}:${number}:${number}Z`
