package com.vti.testing.form.account;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DeleteAccountForm {
    private List<Integer> ids;
}
