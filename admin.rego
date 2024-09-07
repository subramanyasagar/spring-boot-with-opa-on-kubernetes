package sample

import future.keywords.if
import future.keywords.in

default allow = false

allow if {
	some i, "admin" in input.path
    some j, "ADMIN_ROLE" in input.roles
    "POST" == input.method
}

allow if {
 not "POST" == input.method
}