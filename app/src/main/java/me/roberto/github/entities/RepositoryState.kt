package me.roberto.github.entities

data class RepositoryState(val repositories: List<Repository>?, val status:Int) {

    companion object {

        public val STATUS_SUCCESS=0
        public val STATUS_ERROR=1
    }
}