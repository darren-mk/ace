module Fffp.DesigningWithTypes

open Xunit
open FsUnit.Xunit

type PersonalName =
    { FirstName: string
      MiddleInitial: string
      LastName: string }

module EmailAddress =
    type T = EmailAddress of string

    let create (s: string) =
        if System.Text.RegularExpressions.Regex.IsMatch(s, @"^\S+@\S+\.\S+$") then
            Some(EmailAddress s)
        else
            None
